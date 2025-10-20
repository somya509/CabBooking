package cabBooking.example.cabBooking.dto;

import java.util.List;
import java.util.Optional;

public interface MatchingStrategy {
    Optional<Driver> findDriver(location location, List<Driver> driverCondidates);

    }

