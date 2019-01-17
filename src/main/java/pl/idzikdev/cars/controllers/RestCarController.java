package pl.idzikdev.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.idzikdev.cars.models.Car;
import pl.idzikdev.cars.repositories.CarRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class RestCarController {
    @Autowired
    private CarRepository repository;

    public RestCarController(CarRepository repository) {
        this.repository=repository;
    }
    @GetMapping("cars")
    public List<Car> getCarById(){
        return  repository.findAll();
    }
    @GetMapping("cars/id")
    public ResponseEntity<Car> getCar(@RequestParam (name = "id") Long id){
        Optional<Car> optionalCar=repository.findById(id);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<Car> getCarByIdPath(@PathVariable (name = "id") Long id){
        Optional<Car> optionalCar=repository.findById(id);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("cars/year")
    public List<Car> getCarByYear(@RequestParam (name = "year") String year){
        return repository.findByYear(year);
    }

    @GetMapping("cars/power")
    public List<Car> getCarByPower(
            @RequestParam (name = "from") String from,
            @RequestParam (name = "to") String to){
        return repository.findByBetweenPower(from,to);
    }

    @GetMapping("cars/model")
    public ResponseEntity<Car> addCar(@RequestParam (value = "model") String model){
        Optional<Car> optionalCar=repository.findByModel(model);
        if (optionalCar.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(optionalCar.get(),HttpStatus.NOT_FOUND);
    }

    @PostMapping("cars/model")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Optional<Car> optionalCar=repository.findByModel(car.getModel());
        if (optionalCar.isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(repository.save(car),HttpStatus.OK);
    }
    @PutMapping("cars/update")
    public ResponseEntity<Car> updateCar(@RequestParam String model, @RequestBody Car car){
        Optional<Car> optionalCar=repository.findByModel(model);
        if (optionalCar.isPresent()){
            optionalCar.get().setBrand(car.getBrand());
            optionalCar.get().setModel(car.getModel());
            optionalCar.get().setYear(car.getYear());
            optionalCar.get().setPower(car.getPower());
            optionalCar.get().setPicture(car.getPicture());
            return new ResponseEntity<>(repository.save(optionalCar.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("cars/delete")
    public ResponseEntity<Car> deleteCarByModel(@RequestParam String model){
        Optional<Car> optionalCar=repository.findByModel(model);
        if (optionalCar.isPresent()){
            repository.delete(optionalCar.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

