package com.card_game.cardgame.domains.card;

import com.card_game.cardgame.domains.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController extends AbstractController<Card> {

    @Autowired
    private CardService cardService;
}
