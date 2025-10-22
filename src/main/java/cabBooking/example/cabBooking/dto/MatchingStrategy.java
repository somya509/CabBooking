package cabBooking.example.cabBooking.dto;

import javax.xml.stream.Location;
import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

public interface MatchingStrategy {


    default Optional<Driver> findDriver(location userlocation, List<Driver> driverCondidates) {
        final double Max_distance = 5.0;
        double nearestDistance = Double.MAX_VALUE;
        Driver nearestDriver = null;
        out.println("finding nearby driver for user at: " + userlocation.getLatitude() + "," + userlocation.getLongitude());
        for (Driver driver : driverCondidates) {

            if (!driver.isAvailabilty()) continue;
            ;
            double distance = calculateDistance(userlocation.getLatitude(), userlocation.getLongitude(), driver.getLocation().getLatitude(), driver.getLocation().getLongitude());
            out.println("checking driver" + driver.getName() + " | Distance" + distance + "km");
            if (distance <= Max_distance && distance < nearestDistance) {
                nearestDriver = driver;
            }
        }
        return Optional.ofNullable(nearestDriver);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R =6371;
        double latDiff= Math.toRadians(lat2-lat1);
        double lonDiff =Math.toRadians(lon2-lon1);
        double a=Math.sin(latDiff/2) * Math.sin(latDiff/2)+Math.cos(Math.toRadians(lat1))*
                Math.cos(Math.toRadians(lat2))*Math.sin(lonDiff/2) *2 *Math.sin(lonDiff/2);
        double c=2 *Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return R * c;
    }
static  void  main (String[] args)
{
    location userLocation =new location(12.6,77.78);
    List<Driver> drivers=List.of(new Driver(12,56,true,new location(4.2d,3.2d),23,"john",87543),new Driver(17,576,true,new location(5d,7d),26,"johyn",8754369),new Driver(17,856,false,new location(584d,7d),13,"joh08n",875487543));
    MatchingStrategy matchingStrategy=new MatchingStrategy() {
    };
    Optional<Driver> nearest=matchingStrategy.findDriver(userLocation,drivers);
    nearest.ifPresentOrElse(driver -> out.println("\n driver assigned :"+driver.getName()),()-> out.println("\n no driver nearby available !"));
    }


}