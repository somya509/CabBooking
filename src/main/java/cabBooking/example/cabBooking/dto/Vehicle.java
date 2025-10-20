package cabBooking.example.cabBooking.dto;

import lombok.Data;

@Data
public class Vehicle {
    private int number;
    private String type;
     private String Model;
     private short capicity;

    public Vehicle(int number, String type, String model) {
        this.number = number;
        this.type = type;
        Model = model;
    }
}
