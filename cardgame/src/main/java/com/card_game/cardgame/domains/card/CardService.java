package com.card_game.cardgame.domains.card;

import com.card_game.cardgame.domains.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService extends AbstractService<Card, Long> {

    public CardService(JpaRepository<Card, Long> repository) {
        super(repository);
    }

    @Override
    public Card update(Card entity, Long id) {
        Card cardFound = getById(id);
        cardFound.setName(entity.getName());
        cardFound.setDescription(entity.getDescription());
        cardFound.setTargetType(entity.getTargetType());
        cardFound.setDamage(entity.getDamage());
        cardFound.setSelfDamage(entity.getSelfDamage());
        cardFound.setHealing(entity.getHealing());
        cardFound.setArmor(entity.getArmor());
        cardFound.setStatusEffect(entity.getStatusEffect());
        return repository.save(cardFound);
    }

}
