package com.card_game.cardgame.domains.statuseffect;

import com.card_game.cardgame.domains.playerstatus.PlayerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StatusEffect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int damagePerTurn;
    private int healingPerTurn;
    private int armorPerTurn;
    private int duration;


}
