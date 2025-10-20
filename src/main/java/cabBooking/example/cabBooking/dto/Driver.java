package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver  extends AppUser {
    private int drivingLicenceNumber;
private int vehicleNumber;
private boolean availabilty;
private location location;



    public Driver(int drivingLicenceNumber, int vehicleNumber, boolean availabilty, location location, int id, String name, int mobileNumber) {
                        super(id,name,mobileNumber);
                        this.drivingLicenceNumber=drivingLicenceNumber;
                        this.vehicleNumber=vehicleNumber;
                        this.availabilty=availabilty;
                        this.location=location;
    }


    @Override
    public String getRole() {
        return "driver";
    }

}
