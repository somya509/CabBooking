package cabBooking.example.cabBooking.factory;

import cabBooking.example.cabBooking.dto.Driver;
import cabBooking.example.cabBooking.dto.Passenger;
import cabBooking.example.cabBooking.dto.location;

public class UserFactory {
    public static Passenger createPassenger(int id,String name,int mobileNumber)
    {
        return new Passenger(id,name,mobileNumber);
    }
    public static Driver createDriver(int drivingLicenceNumber, int vehicleNumber, boolean availabilty, location location,int id,String name,int mobileNumber)
    {
        return new Driver(drivingLicenceNumber,vehicleNumber,availabilty,location,id,name,mobileNumber);
    }
}
