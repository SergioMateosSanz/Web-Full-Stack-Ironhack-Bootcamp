package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MathSection extends SectionInherence {
    private final int mathCredits;

    public MathSection(int mathCredits) {
        this.mathCredits = mathCredits;
    }

    public MathSection(String id, String courseCode, short roomNumber, String professor, int mathCredits) {
        super(id, courseCode, roomNumber, professor);
        this.mathCredits = mathCredits;
    }

    public int getMathCredits() {
        return mathCredits;
    }
}
