package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.CardState;
import com.endava.smartdesk.data.Visit;
import com.endava.smartdesk.repository.CardRepository;
import com.endava.smartdesk.repository.VisitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VisitController {

    private final VisitRepository visitRepository;
    private final CardRepository cardRepository;

    public VisitController(VisitRepository visitRepository,
                           CardRepository cardRepository) {
        this.visitRepository = visitRepository;
        this.cardRepository = cardRepository;
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    @PostMapping("/visit")
    public ResponseEntity<Card> postVisit(@RequestBody Visit visit) {
        List<Card> availableCards = cardRepository.findByState(CardState.AVAILABLE.getState());

        if (!availableCards.isEmpty()) {
            Card card = availableCards.get(0);
            card.setState(CardState.ASSIGNED.getState());
            cardRepository.save(card);
            visit.setVisitorCard(card);
            visitRepository.save(visit);
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping("/update-visit/{visitId}/{visitState}/{cardState}")
    public void updateVisit(@PathVariable Integer visitId, @PathVariable Integer visitState,
                            @PathVariable Integer cardState) {
        Visit visit = visitRepository.getById(visitId);
        Card card = visit.getVisitorCard();
        card.setState(cardState);
        cardRepository.save(card);
        visit.setState(visitState);
        visitRepository.save(visit);
    }

    @DeleteMapping("/visit/{id}")
    void deleteVisit(@PathVariable Integer id) {
        visitRepository.deleteById(id);
    }
}
