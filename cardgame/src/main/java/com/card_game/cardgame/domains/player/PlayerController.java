package com.card_game.cardgame.domains.player;

import com.card_game.cardgame.domains.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController extends AbstractController<Player> {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public Player createPlayer(@RequestBody PlayerAddRequest playerRequest) {
        System.out.println(playerRequest);
        return playerService.createPlayer(playerRequest.getName(), playerRequest.getClassId());
    }

    @PostMapping("/{playerId}/addStatusEffect/{statusEffectId}")
    public ResponseEntity<Void> addStatusEffect(@PathVariable Long playerId, @PathVariable Long statusEffectId) {
        playerService.addStatusEffect(playerId, statusEffectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}/removeStatusEffect/{playerStatusId}")
    public ResponseEntity<Void> removeStatusEffect(@PathVariable Long playerId, @PathVariable Long playerStatusId) {
        playerService.removeStatusEffect(playerId, playerStatusId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
