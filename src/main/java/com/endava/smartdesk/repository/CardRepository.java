package com.endava.smartdesk.repository;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByLocation(Location location);

    List<Card> findByLocationAndDeleted(Location location, Integer deleted);

    List<Card> findByStateAndLocationAndDeleted(Integer state, Location location, Integer deleted);

}
