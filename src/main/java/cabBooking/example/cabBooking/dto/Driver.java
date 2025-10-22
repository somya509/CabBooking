package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
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

    // 👇 NEW METHODS for accept/reject
    public boolean acceptRide(Ride ride) {
        System.out.println(getName() + " accepted ride " + ride.getRideId());
        this.availabilty = false;
        ride.setStatus(RideStatus.ACCEPTED);
        return true;
    }

    public boolean rejectRide(Ride ride) {
        System.out.println(getName() + " rejected ride " + ride.getRideId());
        this.availabilty = true;
        ride.setStatus(RideStatus.REJECTED);
        return false;
    }

    // Optional simulation method (used for testing)
    public boolean simulateDecision() {
        return new Random().nextBoolean(); // Randomly accept or reject
    }
}
