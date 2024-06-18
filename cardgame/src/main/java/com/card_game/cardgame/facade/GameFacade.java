package com.card_game.cardgame.facade;

import com.card_game.cardgame.domains.card.Card;
import com.card_game.cardgame.domains.card.CardService;
import com.card_game.cardgame.domains.game.Game;
import com.card_game.cardgame.domains.game.GameService;
import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.domains.player.PlayerService;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
import com.card_game.cardgame.handler.CardHandlerChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameFacade {

    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardHandlerChain cardHandlerChain;

    public Long startNewGame(Long player1Id, Long player2Id ) {
        Player player1 = playerService.getById(player1Id);
        Player player2 = playerService.getById(player2Id);
        Game game = gameService.createGame(player1, player2);

        return game.getId();
    }

    public void processTurn(Long gameId, Long player1CardId, Long player2CardId) {
        Game game = gameService.getById(gameId);

        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        Card card1 = cardService.getById(player1CardId);
        Card card2 = cardService.getById(player2CardId);

        cardHandlerChain.processCard(card1, player1, player2);

        cardHandlerChain.processCard(card2, player2, player1);

        applyEndOfTurnEffects(player1);
        applyEndOfTurnEffects(player2);

        if (player1.getLife() <= 0 || player2.getLife() <= 0) {
            game.setFinished(true);
            gameService.update(game, gameId);
        } else {
            game.setPlayer1Turn(!game.isPlayer1Turn());
            gameService.update(game, gameId);
        }

        playerService.update(player1, player1.getId());
        playerService.update(player2, player2.getId());
    }

    private void applyEndOfTurnEffects(Player player) {
        player.getStatuses().forEach(playerStatus -> {
            if (playerStatus.getRemainingTurns() > 0) {
                StatusEffect effect = playerStatus.getStatusEffect();
                player.setLife(player.getLife() + effect.getHealingPerTurn());
                player.setArmor(player.getArmor() + effect.getArmorPerTurn());
                player.setLife(player.getLife() - effect.getDamagePerTurn());
                
                playerStatus.setRemainingTurns(playerStatus.getRemainingTurns() - 1);

                if (playerStatus.getRemainingTurns() <= 0) {
                    playerService.removeStatusEffect(player.getId(), playerStatus.getId());
                }
            }
        });
    }
}
