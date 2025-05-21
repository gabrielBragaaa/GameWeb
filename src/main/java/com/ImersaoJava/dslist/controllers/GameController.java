package com.ImersaoJava.dslist.controllers;

import com.ImersaoJava.dslist.dto.GameMinDto;
import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//Anotation para config a classe para ser um controlador
@RequestMapping(value = "/games") //recurso de games
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;

    }
}
