package com.card_game.cardgame.domains.classes;

import com.card_game.cardgame.domains.card.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "classType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("classType")
    private List<Card> cards;
}
