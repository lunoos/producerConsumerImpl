public interface CustomeQueue { 
    void addTask(Task task);
    Task pullTask();
    int size();
    boolean isEmpty();
}
