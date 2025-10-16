package cabBooking.example.cabBooking.Service;

import cabBooking.example.cabBooking.dto.Driver;
import cabBooking.example.cabBooking.dto.Ride;
import cabBooking.example.cabBooking.dto.User;
import cabBooking.example.cabBooking.dto.location;


import java.util.*;

public class BookingService {

  private final  List<Driver> drivers =new ArrayList<>();

  private final Map<UUID, Ride> rides= new HashMap<UUID, Ride>();
    void addDriver(Driver d) { drivers.add(d); }
   public synchronized Ride   bookRide(location destination , location source, User user ) {

       for (Driver driver : drivers) {
           if (driver.isAvailabilty()) {

               driver.setAvailabilty(false);
               UUID rideId = UUID.randomUUID();
               Ride ride = new Ride(destination, source, rideId, user, UUID.randomUUID(), driver, System.currentTimeMillis());
               rides.put(rideId, ride);
               System.out.println("driver" +driver.getName() + "got assign to rideId" +ride.getRideId());
               return ride;
           }
           System.out.println("no drivers are avialble");
       }

       return null;
   }

    public static void main(String[] args) {
        BookingService bookingService=new BookingService();
        Driver addDriver1 =new Driver(UUID.randomUUID(),"kanpur",23456,987,true,new location(1026d ,1026d));
        Driver addDriver2 =new Driver(UUID.randomUUID(),"nawabganj",29456,9987,false,new location(1026d ,1026d));
        Driver addDriver3 =new Driver(UUID.randomUUID(),"nawabganj",29456,9987,true,new location(1026d ,1026d));
        bookingService.addDriver(addDriver1);
        bookingService.addDriver(addDriver2);
        bookingService.addDriver(addDriver3);

        User user1 =new User("somya",98765876,"lucknow");

location source =new location(1026d ,1026d);
location destination =new location(1086d,1086d);
        bookingService.bookRide(source,destination,user1);
    }
}
