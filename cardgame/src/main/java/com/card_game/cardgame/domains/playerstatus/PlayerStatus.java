package com.card_game.cardgame.domains.playerstatus;

import com.card_game.cardgame.domains.player.Player;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlayerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "status_effect_id")
    private StatusEffect statusEffect;

    private int remainingTurns;

}
