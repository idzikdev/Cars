package pl.idzikdev.cars.services;

import org.springframework.stereotype.Service;
import pl.idzikdev.cars.modules.Car;

import java.util.List;



public interface CarService {
    List<Car> getCars();
    void addCar(Car car);
}
