package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {
    private double pickupLatitude;
    private double pickupLongitude;
    private  String status;



}
