package cabBooking.example.cabBooking.Service;

import cabBooking.example.cabBooking.dto.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverService {
    public static void main(String[] args) {
        List<Driver> drivers= Arrays.asList(new Driver(45,769,true,new location(64,98),36,"soh",006));
        List<Driver> drivers1= Arrays.asList(new Driver(49,799,false,new location(64,86),76,"sgh",986));
        List<Driver> drivers3= Arrays.asList(new Driver(48,749,true,new location(60,876),776,"sghugjh",346));
        List<location> userlocation=Arrays.asList(new location(5,8),
                new location(6,8),new location(5,6));


        MatchingStrategy matchingStrategy=new NearestAvailableStrategy();
        MatchingStrategy matchingStrategy1=new FirstAvailableStrategy();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<String> users=Arrays.asList("somya","Megha","bitto");
        for (int i=0;i< users.size();i++)
        {
            String userName=users.get(i);
            location userloc=userlocation.get(i);
            executor.submit(()->{
                System.out.println("process booking for" +userName+ "at" +userloc);
                synchronized(drivers){
                    Optional<Driver> nearest = matchingStrategy.findDriver(userlocation.get(1), drivers3);

                    nearest.ifPresentOrElse(driver ->
                            System.out.println("nearest available driver :"+ driver.getName() + "at :" + driver.getLocation()),()-> System.out.println("❌ No available drivers found."));

                    Optional<Driver> findFirst =matchingStrategy1.findDriver( userlocation.get(1),drivers);
                    findFirst.ifPresentOrElse(driver -> System.out.println("first driver available :" + driver.getName() + "at :" + driver.getLocation()),()-> System.out.println("❌ No available drivers found ."));

                }

            });
        }

        executor.shutdown();

    }

}
