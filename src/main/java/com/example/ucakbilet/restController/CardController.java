package com.example.ucakbilet.restController;

import com.example.ucakbilet.exception.card.CardNotFoundException;
import com.example.ucakbilet.service.CardService;
import com.example.ucakbilet.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CardController { //TODO URI nedir? araştır /api/card bir URI mıdır?


    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/cards")
    public List<Card> getCards(){
        return cardService.getCards();
    }

    @GetMapping("/cards/{cardId}")
    public Optional<Card> getCard(@PathVariable int cardId){
        Optional<Card> theCard = cardService.getCard(cardId);
        if(theCard== null){
            throw new CardNotFoundException("card id not found - "+cardId);
        }

        return theCard;
    }
    @PostMapping("/cards")
    public Card addCard(@RequestBody Card theCard){
        theCard.setId(0);
        cardService.saveCard(theCard);
        return theCard;
    }

    @PutMapping("/cards")
    public Card updateCard(@RequestBody Card theCard){
        cardService.saveCard(theCard);
        return theCard;

    }
    @DeleteMapping("/cards/{cardId}")
    public String deleteCard(@PathVariable int cardId){
        Optional<Card> tempCard = cardService.getCard(cardId);
        if(tempCard== null){
            throw new CardNotFoundException("card id not found - "+cardId);
        }

        cardService.deleteCard(cardId);

        return "deleted card id"+ cardId;

    }


}
