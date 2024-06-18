package com.card_game.cardgame.domains.game;

import lombok.Data;

@Data
public class ProcessTurnRequest {
    private Long player1CardId;
    private Long player2CardId;
}
