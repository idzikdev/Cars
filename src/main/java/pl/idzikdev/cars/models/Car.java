package pl.idzikdev.cars.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private String year;
    @Column(name = "power")
    private String power;
    @Column(name = "picture")
    private String picture;

    public Car(String brand, String model, String year, String power, String picture) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.power = power;
        this.picture = picture;
    }
}
