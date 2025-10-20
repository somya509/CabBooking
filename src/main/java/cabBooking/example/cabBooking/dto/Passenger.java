package cabBooking.example.cabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passenger extends AppUser{

    public Passenger(int id, String name, int mobileNumber) {
        super(id, name, mobileNumber);
    }

    @Override
    public String getRole() {

        return "passenger";
    }
}
