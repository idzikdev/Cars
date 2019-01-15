package pl.idzikdev.cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idzikdev.cars.models.Car;
import pl.idzikdev.cars.services.CarService;

import javax.validation.Valid;

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
                         @RequestParam(value = "power") String power,
                         @RequestParam(value = "picture") String picture) {
        Car car = Car.builder().
                brand(marka).
                model(model).
                year(year).
                power(power).
                picture(picture).
                build();
        service.addCar(car);
        return "redirect:/cars";
    }
    @PostMapping("addCarPost")
    public String addCarPost(@Valid @ModelAttribute Car car){
        service.addCar(car);
        return "redirect:/cars";
    }
}
