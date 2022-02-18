package com.endava.smartdesk.repository;

import com.endava.smartdesk.data.City;
import com.endava.smartdesk.data.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findByCity(City city);
}
