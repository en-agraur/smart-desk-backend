package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Country;
import com.endava.smartdesk.repository.CountryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    private List<Country> getCountries() {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, Country.COLUMN_NAME));
    }

    @PostMapping("/country")
    public void postCountry(@RequestBody Country country) {
        countryRepository.save(country);
    }

    @DeleteMapping("country/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryRepository.deleteById(id);
    }
}
