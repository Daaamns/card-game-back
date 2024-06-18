package com.card_game.cardgame.domains.statuseffect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEffectRepository extends JpaRepository<StatusEffect, Long> {
}
