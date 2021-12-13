package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.City;
import com.endava.smartdesk.repository.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @PostMapping("/city")
    public void postCity(@RequestBody City city) {
        cityRepository.save(city);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityRepository.deleteById(id);
    }
}
