package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.enums.TargetType;
import org.springframework.stereotype.Component;

@Component
public class HealingCardHandler extends CardHandler {

    @Override
    public void handle(Card card, Player player, Player opponent) {
        if (card.getHealing() > 0) {
            if (card.getTargetType() == TargetType.SELF || card.getTargetType() == TargetType.BOTH) {
                player.setLife(player.getLife() + card.getHealing());
            }
            if (card.getTargetType() == TargetType.OPPONENT || card.getTargetType() == TargetType.BOTH) {
                opponent.setLife(opponent.getLife() + card.getHealing());
            }
        }
        super.handle(card, player, opponent);
    }
}
