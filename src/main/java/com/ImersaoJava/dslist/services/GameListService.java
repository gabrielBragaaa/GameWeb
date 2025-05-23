package com.ImersaoJava.dslist.services;

import com.ImersaoJava.dslist.dto.GameListDto;
import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.entities.GameList;
import com.ImersaoJava.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();
    }

    //Reordenação de posição na lista de jogos
    @Transactional
    public void move(Long listId,int sourceIndex , int destinationIndex ){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }

}
