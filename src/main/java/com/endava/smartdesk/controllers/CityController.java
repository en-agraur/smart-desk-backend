package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.City;
import com.endava.smartdesk.data.Country;
import com.endava.smartdesk.repository.CityRepository;
import com.endava.smartdesk.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CityController {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CityController(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("cities-by-country/{countryId}")
    public ResponseEntity<List<City>> getCitiesByCountry(@PathVariable Integer countryId) {
        Optional<Country> country = countryRepository.findById(countryId);

        if (country.isPresent()) {
            List<City> cities = cityRepository.findByCountry(country.get());
            return new ResponseEntity<>(cities, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/city/{countryId}")
    public ResponseEntity<Void> postCity(@PathVariable Integer countryId, @RequestBody City city) {
        Optional<Country> country = countryRepository.findById(countryId);

        if (country.isPresent()) {
            city.setCountry(country.get());
            cityRepository.save(city);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityRepository.deleteById(id);
    }
}
