package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private int id;

    private String studentName;
    private String sectionId;
    private byte score;

    public Grade() {
    }

    public Grade(String studentName, String sectionId, byte score) {
        this.studentName = studentName;
        this.sectionId = sectionId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return id == grade.id && score == grade.score && Objects.equals(studentName, grade.studentName) && Objects.equals(sectionId, grade.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, sectionId, score);
    }
}
