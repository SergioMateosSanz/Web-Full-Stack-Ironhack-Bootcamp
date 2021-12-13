package com.ironhack.demo.model;

import com.ironhack.demo.enums.House;
import com.ironhack.demo.enums.Wing;

import javax.persistence.*;

@Entity
public class HouseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private House name;
    @Enumerated(EnumType.STRING)
    private Wing wing;
    private int roomNumber;

    @OneToOne(mappedBy = "houseAssignment")
    private StudentPotterWorld studentPotterWorld;

    public HouseAssignment() {
    }

    public HouseAssignment(House name, Wing wing, int roomNumber) {
        this.name = name;
        this.wing = wing;
        this.roomNumber = roomNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public House getName() {
        return name;
    }

    public void setName(House name) {
        this.name = name;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
