package pl.idzikdev.cars.services;

import pl.idzikdev.cars.modules.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    void addCar(Car car);
}
