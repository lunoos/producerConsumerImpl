import java.util.LinkedList;

class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        CustomeQueue customeQueue = new CustomeQueueImpl(new LinkedList<>(),4);
        Producer producer = new ProducerImpl(customeQueue);
        Consumer consumer = new ConsumerImpl(customeQueue);
        long startTime = System.currentTimeMillis();
        for(int i=0; i<25; i++){
            int rand = 1 + (int)(Math.random() * 10);
            producer.assignTask(new TaskImpl(1,("task"+i)));
            // if(i==10) {
            //     try {
            //         Thread.sleep(25000);
            //     } catch (InterruptedException e) {
            //         Thread.currentThread().interrupt();
            //     }
            // }
            // if(i==15) {
            //     try {
            //         Thread.sleep(20000);
            //     } catch (InterruptedException e) {
            //         Thread.currentThread().interrupt();
            //     }
            // }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken by for loop: " + (endTime - startTime) + " ms");
        // allow consumers some time to finish remaining tasks
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // gracefully stop consumer threads
        //consumer.stopConsumers();
    }
}