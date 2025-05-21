package com.ImersaoJava.dslist.repositories;

import com.ImersaoJava.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
                                         //Tenho que por o tipo da entidade e o tipo do id
public interface GameRepository extends JpaRepository<Game, Long> {



}
