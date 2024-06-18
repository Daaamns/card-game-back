package com.card_game.cardgame.domains.card;

import com.card_game.cardgame.domains.classes.Class;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
import com.card_game.cardgame.enums.TargetType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int damage;
    private int selfDamage;
    private int healing;
    private int armor;

    @Enumerated(EnumType.STRING)
    private TargetType targetType;


    @ManyToOne
    @JoinColumn(name = "status_effect_id")
    private StatusEffect statusEffect;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonIgnoreProperties("cards")
    private Class classType;
}
