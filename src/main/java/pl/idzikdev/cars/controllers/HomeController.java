package pl.idzikdev.cars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idzikdev.cars.modules.Car;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    public String getIndex(){
        return "index";
    }
}
