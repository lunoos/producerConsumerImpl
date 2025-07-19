import java.util.LinkedList;

public class CustomeQueueImpl implements CustomeQueue {
    
    private LinkedList<Task> queue;

    private int max;

    public CustomeQueueImpl(LinkedList<Task> queue, int max){
        this.queue = queue;
        this.max = max;
    }

    Object notEmpty = new Object();
    Object notFull = new Object();

    @Override
    public void addTask(Task task) {
        synchronized (notFull) {
            while(queue.size()==max){
                try {
                    notFull.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.add(task);
        }
        synchronized (notEmpty) {
            notEmpty.notifyAll();
        }
    }

    @Override
    public Task pullTask() {
        Task task;
        synchronized (notEmpty) {
            while (queue.size()==0) {
                try {
                    notEmpty.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            task = queue.poll();
        }
        synchronized (notFull) {
            notFull.notifyAll();
        }
        return task;
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
