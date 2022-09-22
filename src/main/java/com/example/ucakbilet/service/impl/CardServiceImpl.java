package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.service.CardService;
import com.example.ucakbilet.entity.Card;
import com.example.ucakbilet.dao.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    @Transactional
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCard(Card theCard) {
        cardRepository.save(theCard);

    }

    @Override
    @Transactional
    public Optional<Card> getCard(int theId) {

       return cardRepository.findById(theId);
    }

    @Override
    @Transactional
    public void deleteCard(int theId) {
        cardRepository.deleteById(theId);

    }


}
