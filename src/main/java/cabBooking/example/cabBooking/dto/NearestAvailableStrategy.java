package cabBooking.example.cabBooking.dto;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NearestAvailableStrategy implements MatchingStrategy{
    @Override
    public Optional<Driver> findDriver(location location, List<Driver> driverCondidates) {
        return driverCondidates.stream().filter(Driver::isAvailabilty).min(Comparator.comparingDouble(d-> d.getLocation().getLatitude()-location.getLatitude()));
    }
    private static double distance(location a,location b)
    {
       double dx=a.getLatitude()-a.getLatitude();
       double dy=b.getLongitude()-b.getLongitude();
       return Math.sqrt(dx * dx + dy * dy);
    }
}
