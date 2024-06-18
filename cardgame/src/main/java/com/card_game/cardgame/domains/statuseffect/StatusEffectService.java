package com.card_game.cardgame.domains.statuseffect;

import com.card_game.cardgame.domains.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusEffectService extends AbstractService<StatusEffect, Long> {

    public StatusEffectService(JpaRepository<StatusEffect, Long> repository) {
        super(repository);
    }

    @Override
    public StatusEffect update(StatusEffect entity, Long id) {
        StatusEffect foundStatusEffect = getById(id);
        foundStatusEffect.setName(entity.getName());
        foundStatusEffect.setDuration(entity.getDuration());
        return repository.save(foundStatusEffect);
    }
}
