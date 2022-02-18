package com.endava.smartdesk.repository;

import com.endava.smartdesk.data.City;
import com.endava.smartdesk.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByCountry(Country country);
}
