package com.endava.smartdesk.controllers;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/cards")
    public List<Card> getCards() {
        return cardRepository.findAll();
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
