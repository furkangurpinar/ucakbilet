package com.example.ucakbilet.service;


import com.example.ucakbilet.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {


    List<Card> getCards();

    void saveCard (Card theCard);

    Optional<Card> getCard(int theId);

    void deleteCard(int theId);
}
