package pl.idzikdev.cars.services;

import org.springframework.stereotype.Service;
import pl.idzikdev.cars.modules.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService{
    List<Car> cars=new ArrayList<>();

    public CarServiceImp() {
        loadCars();
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void addCar(Car car) {
        this.cars.add(car);
    }
    private void loadCars(){
        System.out.println("Loading cars list .....");
        cars=new ArrayList<>();
        cars.add(new Car("Skoda","Fabia","2004","63"));
        cars.add(new Car("Skoda","Fabia","2008","73"));
        cars.add(new Car("Skoda","Fabia","2010","83"));
        cars.add(new Car("Skoda","Fabia","2012","93"));
    }
}
