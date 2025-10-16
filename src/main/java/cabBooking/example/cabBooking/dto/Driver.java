package cabBooking.example.cabBooking.dto;

import lombok.Data;

@Data
public class Driver {
    private int driverId;
private String name;
private int drivingLicenceNumber;
private int vehicleNumber;
private boolean availabilty;
private location location;
}
