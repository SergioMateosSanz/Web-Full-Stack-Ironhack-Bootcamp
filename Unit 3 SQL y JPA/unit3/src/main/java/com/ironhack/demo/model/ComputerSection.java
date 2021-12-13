package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ComputerSection extends SectionInherence {
    private final int computerCredits;

    public ComputerSection(int computerCredits) {
        this.computerCredits = computerCredits;
    }

    public ComputerSection(String id, String courseCode, short roomNumber, String professor, int computerCredits) {
        super(id, courseCode, roomNumber, professor);
        this.computerCredits = computerCredits;
    }

    public int getComputerCredits() {
        return computerCredits;
    }
}
