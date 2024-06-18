package com.card_game.cardgame.domains.statuseffect;

import com.card_game.cardgame.domains.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
@RequiredArgsConstructor
public class StatusEffectController extends AbstractController<StatusEffect> {

    @Autowired
    private StatusEffectService statusEffectService;
}
