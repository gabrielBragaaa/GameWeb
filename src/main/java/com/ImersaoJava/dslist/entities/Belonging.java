package com.ImersaoJava.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
  private BelongingPK id = new BelongingPK();
  private Integer posistion;

  public Belonging(){

  }

    public Belonging(Game game,GameList list,Integer posistion) {
         id.setGame(game);
         id.setList(list);
        this.posistion = posistion;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosistion() {
        return posistion;
    }

    public void setPosistion(Integer posistion) {
        this.posistion = posistion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
