package com.prgrms.setgame.controller.api;

import com.prgrms.setgame.model.Card;
import com.prgrms.setgame.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/cards")
@RestController
public class CardRestController {
    private final CardService cardService;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public List<Card> cardList() {
        return cardService.cards();
    }

    @GetMapping("/add")
    public List<Card> addCardList() {
        return cardService.addCards();
    }
}
