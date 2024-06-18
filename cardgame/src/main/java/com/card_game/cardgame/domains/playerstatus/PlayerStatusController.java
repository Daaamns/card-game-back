package com.card_game.cardgame.domains.playerstatus;

import com.card_game.cardgame.domains.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playerstatus")
@RequiredArgsConstructor
public class PlayerStatusController extends AbstractController<PlayerStatus> {

    @Autowired
    private PlayerStatusService playerStatusService;
}
