package com.ImersaoJava.dslist.repositories;

import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
