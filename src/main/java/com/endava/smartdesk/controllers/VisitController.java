package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.Visit;
import com.endava.smartdesk.repository.CardRepository;
import com.endava.smartdesk.repository.VisitRepository;
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
    public void postVisit(@RequestBody Visit visit) {
        visitRepository.save(visit);
        Card card = visit.getVisitorCard();
        cardRepository.save(card);
    }

    @DeleteMapping("/visit/{id}")
    void deleteVisit(@PathVariable Integer id) {
        visitRepository.deleteById(id);
    }
}
