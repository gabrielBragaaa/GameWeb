package com.ImersaoJava.dslist.controllers;

import com.ImersaoJava.dslist.dto.GameListDto;
import com.ImersaoJava.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return result;
    }

}
