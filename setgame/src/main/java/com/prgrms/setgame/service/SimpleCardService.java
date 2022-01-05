package com.prgrms.setgame.service;

import com.prgrms.setgame.model.Card;
import com.prgrms.setgame.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCardService implements CardService {
    private final CardRepository cardRepository;

    public SimpleCardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> cards() {
        return cardRepository.cards();
    }

    @Override
    public List<Card> addCards() {
        return cardRepository.addCards();
    }

}
