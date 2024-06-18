package com.card_game.cardgame.domains.player;

import com.card_game.cardgame.domains.classes.Class;
import com.card_game.cardgame.domains.playerstatus.PlayerStatus;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
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
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int life;
    private int armor;

    @OneToMany(mappedBy = "player")
   private List<PlayerStatus> statuses;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classType;


    public void addPlayerStatus(PlayerStatus playerStatus) {
        this.statuses.add(playerStatus);
    }

    public void removePlayerStatus(PlayerStatus playerStatus) {
        this.statuses.remove(playerStatus);
    }
}
