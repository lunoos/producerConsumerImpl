public interface CustomQueue { 
    void addTask(Task task);
    Task pullTask();
    int size();
    boolean isEmpty();
}
