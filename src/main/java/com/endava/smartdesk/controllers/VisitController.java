package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Visit;
import com.endava.smartdesk.repository.VisitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController {

    private final VisitRepository visitRepository;

    public VisitController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    @PostMapping("/visit")
    public void postVisit(@RequestBody Visit visit) {
        visitRepository.save(visit);
    }
}
