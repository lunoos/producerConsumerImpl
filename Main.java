class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        CustomQueue customeQueue = new CustomQueueImpl();
        Producer producer = new ProducerImpl(customeQueue);
        Consumer consumer = new ConsumerImpl(customeQueue);
        for(int i=0; i<25; i++){
            int rand = 1 + (int)(Math.random() * 10);
            producer.assignTask(new TaskImpl(rand,("task"+i)));
            if(i==10) {
                try {
                    Thread.sleep(25000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if(i==15) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }   
}