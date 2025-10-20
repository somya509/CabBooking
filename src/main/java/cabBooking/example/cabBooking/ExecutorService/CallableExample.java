package cabBooking.example.cabBooking.ExecutorService;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName() + "calculating sum");
            Thread.sleep(1000);
            return 10 + 20;


        };
        Future<Integer> result = executor.submit(task);
        System.out.println("Result = " + result.get());
        executor.shutdown();
    }
}
