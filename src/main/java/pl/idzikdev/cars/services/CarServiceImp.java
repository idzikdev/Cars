package pl.idzikdev.cars.services;

import org.springframework.stereotype.Service;
import pl.idzikdev.cars.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService{
    List<Car> cars;

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
        cars.add(new Car("Skoda","Fabia","2004","63","https://d-mf.ppstatic.pl/art/2k/6o/o9of83swwcsg0g080soks/ford-mustang-1.1200.jpg"));
        cars.add(new Car("Skoda","Fabia","2008","73","https://i.wpimg.pl/O/644x430/d.wpimg.pl/1293830162-296443334/genewa-2017.jpg"));
        cars.add(new Car("Skoda","Fabia","2010","83","https://i.wpimg.pl/O/644x429/i.wp.pl/a/f/jpeg/37329/05_porsche_911.jpeg"));
        cars.add(new Car("Skoda","Fabia","2012","93","https://i.wpimg.pl/730x0/m.autokult.pl/bmw-m1-2008-335454-1e43073e365b7.jpg"));
        System.out.println(cars);
    }
}
