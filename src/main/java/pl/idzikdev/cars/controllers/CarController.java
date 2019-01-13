package pl.idzikdev.cars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idzikdev.cars.modules.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {
    List<Car> carList=new ArrayList<>();
    @GetMapping("cars")
    public String getCarPage(Model map){
        map.addAttribute("cars",carList);
        return "cars";
    }
    @GetMapping("add")
    public String addCar(ModelMap map,
                         @RequestParam(value = "brand") String marka,
                         @RequestParam(value = "model") String model,
                         @RequestParam(value = "year") String year,
                         @RequestParam(value = "power") String power) {
        Car car = Car.builder().
                brand(marka).
                model(model).
                year(year).
                power(power).
                build();
        carList.add(car);
        map.addAttribute("car", car);
        return "redirect:/cars";
    }
}
