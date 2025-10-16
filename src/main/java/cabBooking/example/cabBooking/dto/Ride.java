package cabBooking.example.cabBooking.dto;

import lombok.Data;

@Data
public class Ride {
    private String destination;
    private String source;
    private  int rideId;
    private int userId;
    private int vehicleId;
    private int driverId;
    private long requestedAt;
}
