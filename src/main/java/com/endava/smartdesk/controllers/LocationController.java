package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.City;
import com.endava.smartdesk.data.Location;
import com.endava.smartdesk.repository.CityRepository;
import com.endava.smartdesk.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class LocationController {

    private final CityRepository cityRepository;
    private final LocationRepository locationRepository;

    public LocationController(CityRepository cityRepository, LocationRepository locationRepository) {
        this.cityRepository = cityRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("locations-by-city/{cityId}")
    public ResponseEntity<List<Location>> getLocationsByCity(@PathVariable Integer cityId) {
        Optional<City> city = cityRepository.findById(cityId);

        if (city.isPresent()) {
            List<Location> locations = locationRepository.findByCity(city.get());
            return new ResponseEntity<>(locations, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/location")
    public void postLocation(@RequestBody Location location) {
        locationRepository.save(location);
    }

    @PostMapping("/location/{cityId}")
    public ResponseEntity<Void> postLocation(@PathVariable Integer cityId, @RequestBody Location location) {
        Optional<City> city = cityRepository.findById(cityId);

        if (city.isPresent()) {
            location.setCity(city.get());
            locationRepository.save(location);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable Integer id) {
        locationRepository.deleteById(id);
    }
}
