package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.enums.TargetType;
import org.springframework.stereotype.Component;

@Component
public class ArmorCardHandler extends CardHandler {

    @Override
    public void handle(Card card, Player player, Player opponent) {
        if (card.getArmor() > 0) {
            if (card.getTargetType() == TargetType.SELF || card.getTargetType() == TargetType.BOTH) {
                player.setArmor(player.getArmor() + card.getArmor());
            }
            if (card.getTargetType() == TargetType.OPPONENT || card.getTargetType() == TargetType.BOTH) {
                opponent.setArmor(opponent.getArmor() + card.getArmor());
            }
        }
        super.handle(card, player, opponent);
    }
}
