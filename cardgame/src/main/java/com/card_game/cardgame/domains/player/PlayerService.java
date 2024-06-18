package com.card_game.cardgame.domains.player;

import com.card_game.cardgame.domains.AbstractService;
import com.card_game.cardgame.domains.classes.Class;
import com.card_game.cardgame.domains.classes.ClassRepository;
import com.card_game.cardgame.domains.playerstatus.PlayerStatus;
import com.card_game.cardgame.domains.playerstatus.PlayerStatusRepository;
import com.card_game.cardgame.domains.statuseffect.StatusEffect;
import com.card_game.cardgame.domains.statuseffect.StatusEffectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService extends AbstractService<Player, Long> {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private PlayerStatusRepository playerStatusRepository;

    @Autowired
    private StatusEffectRepository statusEffectRepository;

    public PlayerService(JpaRepository<Player, Long> repository) {
        super(repository);
    }

    @Override
    public Player update(Player entity, Long id) {
        Player foundPlayer = getById(id);
        foundPlayer.setName(entity.getName());
        foundPlayer.setLife(entity.getLife());
        foundPlayer.setArmor(entity.getArmor());
        foundPlayer.setStatuses(entity.getStatuses());
        foundPlayer.setClassType(entity.getClassType());
        return repository.save(foundPlayer);
    }



    public Player createPlayer(String name, Long classId) {
        Class classType = classRepository.findById(classId).orElseThrow(() -> new RuntimeException("Class not found"));
        Player player = new Player();
        player.setName(name);
        player.setClassType(classType);
        player.setLife(100);
        player.setArmor(10);
        return repository.save(player);
    }

    public void addStatusEffect(Long playerId, Long statusEffectId) {
        Player player = getById(playerId);
        StatusEffect statusEffect = statusEffectRepository.findById(statusEffectId).orElseThrow(
                () -> new EntityNotFoundException("No status effect with id " + statusEffectId)
        );
        PlayerStatus playerStatus = new PlayerStatus();
        playerStatus.setPlayer(player);
        playerStatus.setStatusEffect(statusEffect);
        playerStatus.setRemainingTurns(statusEffect.getDuration());
        playerStatusRepository.save(playerStatus);
    }

    public void removeStatusEffect(Long playerId, Long playerStatusId) {
        PlayerStatus playerStatus = playerStatusRepository.findById(playerStatusId).orElseThrow(
                () -> new EntityNotFoundException("No player status with id " + playerStatusId)
        );
        playerStatusRepository.delete(playerStatus);
    }
}
