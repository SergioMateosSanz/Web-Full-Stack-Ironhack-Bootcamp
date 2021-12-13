package com.ironhack.demo.model;

import com.ironhack.demo.enums.LevelSpell;

import javax.persistence.*;
import java.util.List;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private LevelSpell levelSpell;

    public Spell() {
    }

    public Spell(String name, LevelSpell levelSpell) {
        this.name = name;
        this.levelSpell = levelSpell;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LevelSpell getLevelSpell() {
        return levelSpell;
    }

    public void setLevelSpell(LevelSpell levelSpell) {
        this.levelSpell = levelSpell;
    }

}
