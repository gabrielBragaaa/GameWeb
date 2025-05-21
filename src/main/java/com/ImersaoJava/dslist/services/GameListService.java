package com.ImersaoJava.dslist.services;

import com.ImersaoJava.dslist.dto.GameListDto;
import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.entities.GameList;
import com.ImersaoJava.dslist.repositories.GameListRepository;
import com.ImersaoJava.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component // anotation que precisa ser feito que possa fazer parte do sistema
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();
    }


}
