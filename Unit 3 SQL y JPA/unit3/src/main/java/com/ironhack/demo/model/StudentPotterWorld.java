package com.ironhack.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentPotterWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    private HouseAssignment houseAssignment;

    @ManyToMany
    @JoinTable(name = "students_casts_spells",
            joinColumns = { @JoinColumn(name = "id_student") },
            inverseJoinColumns = { @JoinColumn(name = "id_spell") })
    private List<Spell> spellList;

    public StudentPotterWorld() {
    }

    public StudentPotterWorld(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HouseAssignment getHouseAssignment() {
        return houseAssignment;
    }

    public void setHouseAssignment(HouseAssignment houseAssignment) {
        this.houseAssignment = houseAssignment;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
    }
}
