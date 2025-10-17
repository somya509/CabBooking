package cabBooking.example.cabBooking.Service;

import cabBooking.example.cabBooking.dto.Driver;
import cabBooking.example.cabBooking.dto.MatchingStrategy;
import cabBooking.example.cabBooking.dto.NearestAvailableStrategy;
import cabBooking.example.cabBooking.dto.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DriverService {
    public static void main(String[] args) {
        List<Driver> drivers= Arrays.asList(new Driver(45,769,true,new location(64,98),36,"soh",006));
        List<Driver> drivers1= Arrays.asList(new Driver(49,799,false,new location(64,86),76,"sgh",986));
        List<Driver> drivers3= Arrays.asList(new Driver(48,749,true,new location(60,876),776,"sghugjh",346));

location loc =new location(5,8);
        MatchingStrategy matchingStrategy=new NearestAvailableStrategy();
        Optional<Driver> nearest = matchingStrategy.findDriver(loc, drivers);
        nearest.ifPresentOrElse(driver -> System.out.println("nearest available driver :"+ driver.getName() + "at :" + driver.getLocation()),()-> System.out.println("❌ No available drivers found."));
    }
}
