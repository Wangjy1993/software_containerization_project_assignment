package com.vu.sc.web.api;

import com.vu.sc.web.entity.CityEntity;
import com.vu.sc.web.mapper.CityMapper;
import com.vu.sc.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<CityEntity> getCities(Model model) {
        return cityService.findAllCities();
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "Greetings from Spring Boot!";
    }

    @PutMapping("/city")
    public String insertCity(String country,String name,String state,Model model) {
        CityEntity city = new CityEntity();
        city.setCountry(country);
        city.setName(name);
        city.setState(state);

        cityService.addCity(city);
        return "OK !";
    }
}
