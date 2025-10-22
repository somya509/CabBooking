//package cabBooking.example.cabBooking.Service;
//
//import cabBooking.example.cabBooking.dto.Driver;
//import cabBooking.example.cabBooking.dto.Ride;
//import cabBooking.example.cabBooking.dto.RideRequest;
//import cabBooking.example.cabBooking.dto.location;
//import org.springframework.beans.factory.parsing.Location;
//
//import java.util.*;
//
//public class RideService {
//    private final List<RideRequest> rideRequests =new ArrayList<>();
//private Map<UUID, Ride> rides=new HashMap<>();
//public void addRideRequest(RideRequest request)
//{
//    rideRequests.add(request);
//    System.out.println("Ride request added" +request);
//
//    }
//    public synchronized List<RideRequest>getNearbyRides(location userLocation) {
//        List<RideRequest> nearby = new ArrayList<>();
//        System.out.println("checking nearby ride location :" + userLocation.getLatitude() + "," + userLocation.getLongitude());
//    for (RideRequest req : rideRequests)
//    {
//        if (!"PENDING".equalsIgnoreCase(req.getStatus())) continue;
//
//        double distance=calculateDistance()
//    }
//    }
//
//    private double calculateDistance() {
//        return 0;
//    }
//}
