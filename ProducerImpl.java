public class ProducerImpl implements Producer{
    private CustomQueue queue;

    public ProducerImpl(CustomQueue queue){
        this.queue = queue;
    }

    @Override
    public void assignTask(Task task){
        System.out.println("Task: "+task.getName()+" is added to the queue.");
        queue.addTask(task);
    }
}
