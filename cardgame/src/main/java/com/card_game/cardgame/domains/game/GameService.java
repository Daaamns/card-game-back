package com.card_game.cardgame.domains.game;

import com.card_game.cardgame.domains.AbstractService;
import com.card_game.cardgame.domains.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService extends AbstractService<Game, Long> {

    public GameService(JpaRepository<Game, Long> repository) {
        super(repository);
    }

    @Override
    public Game update(Game entity, Long id) {
        Game foudGame = getById(id);
        foudGame.setPlayer1(entity.getPlayer1());
        foudGame.setPlayer2(entity.getPlayer2());
        foudGame.setPlayer1Turn(entity.isPlayer1Turn());
        foudGame.setPlayer1Lost(entity.isPlayer1Lost());
        foudGame.setPlayer2Lost(entity.isPlayer2Lost());
        return repository.save(foudGame);
    }

    public Game createGame(Player player1, Player player2) {
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setPlayer1Turn(true);
        game.setPlayer1Lost(false);
        game.setPlayer2Lost(false);
        return repository.save(game);
    }

    public void setFinished(Game game, boolean isFinished) {
        game.setFinished(isFinished);
        repository.save(game);
    }

    public Game updateGame(Game game) {
        return repository.save(game);
    }


}
