package com.card_game.cardgame.domains.classes;

import com.card_game.cardgame.domains.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/class")
@RequiredArgsConstructor
public class ClassController extends AbstractController<Class> {

    @Autowired
    private ClassService classService;
}
