package cabBooking.example.cabBooking.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Ride {


    private location destination;
    private location source;
    private UUID rideId;
    private User userId;
    private UUID vehicleId;
    private Driver driverId;
    private long requestedAt;

    public Ride(location destination, location source, UUID rideId, User userId, UUID vehicleId, Driver driverId, long requestedAt) {
        this.destination = destination;
        this.source = source;
        this.rideId = rideId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.requestedAt = requestedAt;
    }
}
