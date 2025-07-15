public class ProducerImpl implements Producer{
    private CustomeQueue queue;

    public ProducerImpl(CustomeQueue queue){
        this.queue = queue;
    }

    public void assignTask(Task task){
        System.out.println("Task: "+task.getName()+" is added to the queue.");
        queue.addTask(task);
    }
}
