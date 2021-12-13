package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ScienceSection extends SectionInherence {
    private final int scienceCredits;
    private int laboratoryNumber;

    public ScienceSection(int scienceCredits) {
        this.scienceCredits = scienceCredits;
    }

    public ScienceSection(String id, String courseCode, short roomNumber, String professor, int scienceCredits, int laboratoryNumber) {
        super(id, courseCode, roomNumber, professor);
        this.scienceCredits = scienceCredits;
        this.laboratoryNumber = laboratoryNumber;
    }

    public int getScienceCredits() {
        return scienceCredits;
    }

    public int getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public void setLaboratoryNumber(int laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }
}
