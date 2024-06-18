package com.card_game.cardgame.domains.playerstatus;

import com.card_game.cardgame.domains.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatusService extends AbstractService<PlayerStatus, Long> {

    public PlayerStatusService(JpaRepository<PlayerStatus, Long> repository) {
        super(repository);
    }

    @Override
    public PlayerStatus update(PlayerStatus entity, Long id) {
        PlayerStatus foundPlayerStatus = getById(id);
        foundPlayerStatus.setPlayer(entity.getPlayer());
        foundPlayerStatus.setStatusEffect(entity.getStatusEffect());
        foundPlayerStatus.setRemainingTurns(entity.getRemainingTurns());
        return repository.save(foundPlayerStatus);
    }

}
