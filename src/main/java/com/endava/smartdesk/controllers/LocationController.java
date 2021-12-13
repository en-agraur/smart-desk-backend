package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Location;
import com.endava.smartdesk.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @PostMapping("/location")
    public void postLocation(@RequestBody Location location) {
        locationRepository.save(location);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable Integer id) {
        locationRepository.deleteById(id);
    }
}
