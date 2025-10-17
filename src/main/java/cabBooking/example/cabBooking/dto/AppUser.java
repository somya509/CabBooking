package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public abstract class AppUser {


    private int id ;
    private String name;
    private int mobileNumber;


    public abstract String getRole();
}

