package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.enums.TargetType;
import org.springframework.stereotype.Component;

@Component
public class DamageCardHandler extends CardHandler{

    @Override
    public void handle(Card card, Player player, Player opponent) {
        if (card.getDamage() > 0) {
            int initialDamage = card.getDamage();

            if (card.getTargetType() == TargetType.OPPONENT || card.getTargetType() == TargetType.BOTH) {
                int damageToOpponent = calculateDamage(initialDamage, opponent);
                opponent.setLife(opponent.getLife() - damageToOpponent);
            }

            if (card.getTargetType() == TargetType.SELF || card.getTargetType() == TargetType.BOTH) {
                int damageToSelf = calculateDamage(initialDamage, player);
                player.setLife(player.getLife() - damageToSelf);
            }
        }
        super.handle(card, player, opponent);
    }

    private int calculateDamage(int initialDamage, Player target) {
        int effectiveDamage = initialDamage;

        if (target.getArmor() > 0) {
            if (initialDamage <= target.getArmor()) {
                target.setArmor(target.getArmor() - initialDamage);
                effectiveDamage = 0;
            } else {
                effectiveDamage = initialDamage - target.getArmor();
                target.setArmor(0);
            }
        }

        return effectiveDamage;
    }
}
