package com.ImersaoJava.dslist.services;

import com.ImersaoJava.dslist.dto.GameDTO;
import com.ImersaoJava.dslist.dto.GameMinDto;
import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long Id){
        Game result = gameRepository.findById(Id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
      List<Game> result = gameRepository.findAll();
      List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
      return dto;
   }

}
