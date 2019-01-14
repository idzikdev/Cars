package pl.idzikdev.cars.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.idzikdev.cars.modules.Car;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("car")
    public Car getCar(){
        return new Car("Skoda","Fabia","2010","100");
    }
}
