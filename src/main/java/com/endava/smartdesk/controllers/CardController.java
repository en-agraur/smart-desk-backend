package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.Location;
import com.endava.smartdesk.repository.CardRepository;
import com.endava.smartdesk.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@Slf4j
public class CardController {

    private final CardRepository cardRepository;
    private final LocationRepository locationRepository;

    public CardController(CardRepository cardRepository,
                          LocationRepository locationRepository) {
        this.cardRepository = cardRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/cards/{locationId}")
    public ResponseEntity<List<Card>> getCardsByLocation(@PathVariable Integer locationId) {
        Optional<Location> location = locationRepository.findById(locationId);

        if (location.isPresent()) {
            List<Card> cards = cardRepository.findByLocation(location.get());
            return new ResponseEntity<>(cards, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/card/{locationId}")
    public ResponseEntity<Void> postCard(@PathVariable Integer locationId, @RequestBody Card card) {
        Optional<Location> location = locationRepository.findById(locationId);

        if (location.isPresent()) {
            List<Card> cards = cardRepository.findByCardNumberAndLocation(card.getCardNumber(), location.get());

            if (cards.isEmpty()) {
                card.setLocation(location.get());
                cardRepository.save(card);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                log.info("A card with number " + card.getCardNumber() + " is already assigned to the location " +
                        location.get());
            }
        } else {
            log.info("Couldn't find location with id " + locationId + " when trying to add a new card");
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/card-update/{cardId}/{cardState}")
    public ResponseEntity<Void> updateCard(@PathVariable Integer cardId, @PathVariable Integer cardState) {
        Optional<Card> card = cardRepository.findById(cardId);

        if (card.isPresent()) {
            card.get().setStateDate(new Date(System.currentTimeMillis()));
            card.get().setState(cardState);
            cardRepository.save(card.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @DeleteMapping("/card/{cardId}")
    public void deleteCard(@PathVariable Integer cardId) {
        cardRepository.deleteById(cardId);
    }
}
