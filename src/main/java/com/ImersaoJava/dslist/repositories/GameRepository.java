package com.ImersaoJava.dslist.repositories;

import com.ImersaoJava.dslist.entities.Game;
import com.ImersaoJava.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Classe responsavel por acesso a dados
//Tenho que por o tipo da entidade e o tipo do id
public interface GameRepository extends JpaRepository<Game, Long> {

	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}
