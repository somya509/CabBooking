package cabBooking.example.cabBooking.dto;

import java.util.List;
import java.util.Optional;

public class FirstAvailableStrategy implements MatchingStrategy {

    @Override
    public Optional<Driver> findDriver(location location, List<Driver> driverCondidates) {
        return driverCondidates.stream().filter(Driver::isAvailabilty).findFirst();
    }
}
