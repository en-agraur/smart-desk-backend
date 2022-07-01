package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.*;
import com.endava.smartdesk.repository.CardRepository;
import com.endava.smartdesk.repository.LocationRepository;
import com.endava.smartdesk.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@Slf4j
public class VisitController {

    private final VisitRepository visitRepository;
    private final CardRepository cardRepository;
    private final LocationRepository locationRepository;

    public VisitController(VisitRepository visitRepository,
                           CardRepository cardRepository,
                           LocationRepository locationRepository) {
        this.visitRepository = visitRepository;
        this.cardRepository = cardRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        List<Visit> visits = visitRepository.findAll();
        log.info(visits.toString());
        return visits;
    }

    @GetMapping("/visits/{id}")
    public ResponseEntity<List<Visit>> getVisitsByLocation(@PathVariable Integer id) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isPresent()) {
            List<Card> cards = cardRepository.findByLocation(location.get());
            return new ResponseEntity<>(visitRepository.findByVisitorCardIn(cards), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/visits-by-period/{locationId}")
    public ResponseEntity<List<Visit>> getVisitsByLocationAndPeriod(@PathVariable Integer locationId, @RequestBody Period period) {
        Optional<Location> location = locationRepository.findById(locationId);

        if (location.isPresent()) {
            List<Card> cards = cardRepository.findByLocation(location.get());
            return new ResponseEntity<>(visitRepository.findByVisitorCardInAndDateBetween(cards, period.getFrom(), period.getTo()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/visits-by-period")
    public List<Visit> getVisitsByPeriod(@RequestBody Period period) {
        return visitRepository.findByDateBetween(period.getFrom(), period.getTo());
    }

    @PostMapping("/visit/{locationId}")
    public ResponseEntity<Card> postVisit(@PathVariable Integer locationId, @RequestBody Visit visit) {
        Optional<Location> location = locationRepository.findById(locationId);

        if (location.isPresent()) {
            List<Card> availableCards = cardRepository.findByStateAndLocationAndDeleted(CardState.AVAILABLE.getState(),
                    location.get(), DeletedState.AVAILABLE.getState());

            if (!availableCards.isEmpty()) {
                Card card = availableCards.get(0);
                card.setState(CardState.ASSIGNED.getState());
                cardRepository.save(card);
                visit.setVisitorCard(card);
                visitRepository.save(visit);
                return new ResponseEntity<>(card, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/update-visit/{visitId}/{visitState}/{cardState}")
    public ResponseEntity<Void> updateVisit(@PathVariable Integer visitId, @PathVariable Integer visitState,
                                            @PathVariable Integer cardState) {
        Optional<Visit> visit = visitRepository.findById(visitId);

        if (visit.isPresent()) {
            Card card = visit.get().getVisitorCard();
            card.setState(cardState);
            cardRepository.save(card);
            visit.get().setState(visitState);
            visitRepository.save(visit.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @DeleteMapping("/visit/{id}")
    void deleteVisit(@PathVariable Integer id) {
        visitRepository.deleteById(id);
    }
}
