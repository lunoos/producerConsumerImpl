import java.util.LinkedList;

public class CustomeQueueImpl implements CustomeQueue {
    
    private LinkedList<Task> queue = new LinkedList<>();

    @Override
    public synchronized void addTask(Task task) {
        queue.add(task);
        this.notifyAll();
    }

    @Override
    public synchronized Task pullTask() {
        return queue.poll();
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
