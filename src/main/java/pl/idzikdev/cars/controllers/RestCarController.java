package pl.idzikdev.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.idzikdev.cars.models.Car;
import pl.idzikdev.cars.repositories.CarRepository;

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
}

