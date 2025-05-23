package com.ImersaoJava.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

//Representra uma chave primaria multipla
//Classe auxiliar para ter as refrncias da inha classe Belonging -> Game e GameList
@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList List;

    public BelongingPK(){

    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        List = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return List;
    }

    public void setList(GameList list) {
        List = list;
    }
   //Comparação
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(List, that.List);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, List);
    }
}
