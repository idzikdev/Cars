package pl.idzikdev.cars.controllers;

import ch.qos.logback.core.util.COWArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idzikdev.cars.modules.Car;
import pl.idzikdev.cars.services.CarService;
import pl.idzikdev.cars.services.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarService service;
    public CarController(CarService service) {
    }

    @GetMapping("cars")
    public String getCarPage(Model map){
        map.addAttribute("cars",service.getCars());
        return "cars";
    }
    @GetMapping("add")
    public String addCar(@RequestParam(value = "brand") String marka,
                         @RequestParam(value = "model") String model,
                         @RequestParam(value = "year") String year,
                         @RequestParam(value = "power") String power) {
        Car car = Car.builder().
                brand(marka).
                model(model).
                year(year).
                power(power).
                build();
        service.addCar(car);
        return "redirect:/cars";
    }
}
