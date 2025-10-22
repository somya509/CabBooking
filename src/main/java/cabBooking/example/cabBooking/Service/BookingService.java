package cabBooking.example.cabBooking.Service;

import cabBooking.example.cabBooking.dto.*;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BookingService {

    private final  List<Driver> drivers =new ArrayList<>();
    Set<String> assignedDriver= ConcurrentHashMap.newKeySet();

    private final Map<UUID, Ride> rides= new HashMap<UUID, Ride>();
    private Driver driver;

    void addDriver(Driver d) { drivers.add(d); }
    public synchronized Ride   bookRide(location destination , location source, Passenger user ) {

        for (Driver driver : drivers) {
            if (driver.isAvailabilty()) {

                driver.setAvailabilty(false);
                String driverName = driver.getName() != null ? driver.getName() : "driver" + driver.hashCode();
                boolean isdublicateDriver = !assignedDriver.add(driverName);
                if (isdublicateDriver) {
                    System.out.println("duplicatedriver" + driverName + "");
                }
                UUID rideId = UUID.randomUUID();
                Ride ride = new Ride(destination, source, rideId, user, UUID.randomUUID(), driver, System.currentTimeMillis(), RideStatus.REQUESTED);
                System.out.println("✅ Ride created: " + ride);
                rides.put(rideId, ride);
                System.out.println("driver" + driver.getName() + "got assign to rideId" + ride.getRideId());


                boolean accepted = driver.simulateDecision();

                if (accepted) {
                    driver.acceptRide(ride);
                    System.out.println("🚘 Driver " + driver.getName() + " accepted the ride " + rideId);
                    return ride;
                } else {
                    driver.rejectRide(ride);
                    System.out.println("❌ Driver " + driver.getName() + " rejected the ride " + rideId);
                    driver.setAvailabilty(true); // make available again
                }
            }
            System.out.println("❌ No available drivers accepted the ride.");

            return null;
        }
        return (Ride) rides;
    }
    public static void main(String[] args) {
        BookingService bookingService=new BookingService();
        Driver addDriver1 =new Driver(5678,88765,true,new location(76d,79d));
        addDriver1.setName("John");

        Driver addDriver2 =new Driver(56788,88775,false,new location(716d,709d));
        addDriver2.setName("Ravi");
        Driver addDriver3 =new Driver(568,8678,true,new location(78d,74d));
        addDriver3.setName("Arjun");
        bookingService.addDriver(addDriver1);
        bookingService.addDriver(addDriver2);
        bookingService.addDriver(addDriver3);

        Passenger user1 =new Passenger(765,"SOMYA",897654344);

        location source =new location(1026d ,1026d);
         location   destination = new location(1086d, 1086d);
        bookingService.bookRide(destination,source,user1);
    }

}


