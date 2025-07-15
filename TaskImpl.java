public class TaskImpl implements Task{
    private int time;
    private String name;
    public TaskImpl(int time,String name){
        this.time = time;
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void execute(){
        System.out.println("Task executed in " + time + " seconds");
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
