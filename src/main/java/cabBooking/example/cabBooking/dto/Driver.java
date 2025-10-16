package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Driver {
    private UUID driverId;
private String name;
private int drivingLicenceNumber;
private int vehicleNumber;
private boolean availabilty;
private location location;

}
