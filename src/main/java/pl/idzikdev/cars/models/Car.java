package pl.idzikdev.cars.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {
    private String brand;
    private String model;
    private String year;
    private String power;
    private String picture;
}
