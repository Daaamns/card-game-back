package com.card_game.cardgame.domains.playerstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatusRepository extends JpaRepository<PlayerStatus, Long> {
}
