package com.prgrms.setgame.service;

import com.prgrms.setgame.model.Card;

import java.util.List;

public interface CardService {
    List<Card> cards();

    List<Card> addCards();
}
