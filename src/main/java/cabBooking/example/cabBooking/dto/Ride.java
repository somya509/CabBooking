package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    private location destination;
    private location source;
    private UUID rideId;
    private Passenger userId;
    private UUID vehicleId;
    private Driver driverId;
    private long requestedAt;
     RideStatus status;

    public Ride(location destination, location source, UUID rideId, Passenger user, UUID uuid, Driver driver, long l) {

    }
}
