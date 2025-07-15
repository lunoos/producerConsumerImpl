public class ConsumerImpl implements Consumer{
    
    private final CustomQueue queue;

    public ConsumerImpl(CustomQueue queue) {
        this.queue = queue;
        for (int i = 0; i < 3; i++) {
            Thread worker = new Thread(() -> {
                while (true) {
                    Task task = null;
                    System.out.println("current Thread" +Thread.currentThread().getName());
                    synchronized (queue) {
                        if (!queue.isEmpty()) {
                            task = queue.pullTask();
                        }else{
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                break;
                            }
                        }
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
        }
    }
}
