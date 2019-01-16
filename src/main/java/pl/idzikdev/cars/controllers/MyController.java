package pl.idzikdev.cars.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.idzikdev.cars.models.Car;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("car")
    public Car getCar(){
        return null;
    }
}
