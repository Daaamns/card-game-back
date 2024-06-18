package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;
import org.springframework.stereotype.Component;

@Component
public class CardHandlerChain {
    private CardHandler firstHandler;

    public CardHandlerChain() {
        buildChain();
    }

    private void buildChain() {
        firstHandler = new DamageCardHandler();
        CardHandler healingHandler = new HealingCardHandler();
        CardHandler armorHandler = new ArmorCardHandler();
        CardHandler statusEffectHandler = new StatusEffectCardHandler();

        firstHandler.setNextHandler(healingHandler);
        healingHandler.setNextHandler(armorHandler);
        armorHandler.setNextHandler(statusEffectHandler);
    }

    public void processCard(Card card, Player player, Player opponent) {
        firstHandler.handle(card, player, opponent);
    }
}
