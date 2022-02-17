package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.Location;
import com.endava.smartdesk.repository.CardRepository;
import com.endava.smartdesk.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CardController {

    private final CardRepository cardRepository;
    private final LocationRepository locationRepository;

    public CardController(CardRepository cardRepository,
                          LocationRepository locationRepository) {
        this.cardRepository = cardRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/cards")
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<List<Card>> getCardsByLocation(@PathVariable Integer id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(value -> new ResponseEntity<>(cardRepository.findByLocation(value),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY));

    }

    @PostMapping("/card")
    public void postCard(@RequestBody Card card) {
        cardRepository.save(card);
    }

    @DeleteMapping("/card/{id}")
    public void deleteCard(@PathVariable Integer id) {
        cardRepository.deleteById(id);
    }
}
