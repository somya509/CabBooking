package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int mobileNumber;
    private String address;
}
