package com.card_game.cardgame.domains.player;

import com.card_game.cardgame.domains.classes.Class;
import lombok.Data;

@Data
public class PlayerAddRequest {
        private String name;
        private Long classId;

}
