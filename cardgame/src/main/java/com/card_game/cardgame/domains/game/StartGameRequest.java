package com.card_game.cardgame.domains.game;

import lombok.Data;

@Data
public class StartGameRequest {
    private Long player1Id;
    private Long player2Id;
}
