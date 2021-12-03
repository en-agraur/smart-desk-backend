package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Visit;
import com.endava.smartdesk.repository.VisitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @DeleteMapping("/visit/{id}")
    void deleteVisit(@PathVariable Integer id) {
        visitRepository.deleteById(id);
    }
}
