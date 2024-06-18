package com.card_game.cardgame.domains.classes;

import com.card_game.cardgame.domains.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassService extends AbstractService<Class, Long> {

    public ClassService(JpaRepository<Class, Long> repository) {
        super(repository);
    }

    @Override
    public Class update(Class entity, Long id) {
        Class foudClass = getById(id);
        foudClass.setName(entity.getName());
        foudClass.setCards(entity.getCards());
        return repository.save(foudClass);
    }
}
