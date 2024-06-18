package com.card_game.cardgame.domains.game;

import com.card_game.cardgame.domains.AbstractController;
import com.card_game.cardgame.facade.GameFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController extends AbstractController<Game> {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameFacade gameFacade;

    @PostMapping("/start")
    public ResponseEntity<Long> startNewGame(@RequestBody StartGameRequest request) {
        Long gameId = gameFacade.startNewGame(request.getPlayer1Id(), request.getPlayer2Id());
        return ResponseEntity.ok(gameId);
    }

    @PostMapping("/{gameId}/processTurn")
    public void processTurn(@PathVariable Long gameId, @RequestBody ProcessTurnRequest entity ) {
        gameFacade.processTurn(gameId, entity.getPlayer1CardId(), entity.getPlayer2CardId());
    }
}
