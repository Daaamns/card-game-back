package com.card_game.cardgame.handler;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.domains.player.PlayerService;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
import com.card_game.cardgame.domains.statuseffect.StatusEffectService;
import com.card_game.cardgame.enums.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusEffectCardHandler extends CardHandler{

    @Autowired
    private PlayerService playerService;

    @Override
    public void handle(Card card, Player player, Player opponent) {
        if (card.getStatusEffect() != null) {
            if (card.getTargetType() == TargetType.OPPONENT || card.getTargetType() == TargetType.BOTH) {
                playerService.addStatusEffect(opponent.getId(), card.getStatusEffect().getId());
            }
            if (card.getTargetType() == TargetType.SELF || card.getTargetType() == TargetType.BOTH) {
                playerService.addStatusEffect(player.getId(),  card.getStatusEffect().getId());
            }
        }
        super.handle(card, player, opponent);
    }
}
