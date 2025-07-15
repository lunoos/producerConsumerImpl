import java.util.ArrayList;
import java.util.List;

public class ConsumerImpl implements Consumer{

    private final CustomeQueue queue;
    private final List<Thread> workers = new ArrayList<>();
    private volatile boolean running = true;

    public ConsumerImpl(CustomeQueue queue) {
        this.queue = queue;
        for (int i = 0; i < 3; i++) {
            Thread worker = new Thread(() -> {
                while (running) {
                    Task task = null;
                    System.out.println("current Thread" +Thread.currentThread().getName());
                    synchronized (queue) {
                        if (!queue.isEmpty()) {
                            task = queue.pullTask();
                        } else {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                break;
                            }
                        }
                    }
                    if (!running) {
                        break;
                    }
                    if (task != null) {
                        System.out.println(Thread.currentThread().getName()+" executing the task: "+task.getName());
                        task.execute(); // or any default time
                    } else {
                        try {
                            Thread.sleep(100); // Sleep briefly if no task
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }
            },("Thread"+i));
            worker.start();
            workers.add(worker);
        }
    }

    @Override
    public void stopConsumers() {
        running = false;
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}
