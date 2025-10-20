package cabBooking.example.cabBooking.ExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0; i<=8;i++)
        {
            int taskId=i;
            executor.submit(()->{
                System.out.println("Running task"+ taskId + " by" +Thread.currentThread().getName());
                try {
                    Thread .sleep(1000);

                }
                catch(InterruptedException e) {
e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
