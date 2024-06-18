package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;

public abstract class CardHandler {
    protected CardHandler nextHandler;

    public void setNextHandler(CardHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Card card, Player player, Player opponent) {
        if (nextHandler != null) {
            nextHandler.handle(card, player, opponent);
        }
    }
}
