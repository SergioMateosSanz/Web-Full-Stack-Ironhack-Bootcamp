package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Section {

    @Id
    private String id;
    private String courseCode;
    private short roomNumber;
    private String professor;

    public Section() {
    }

    public Section(String id, String courseCode, short roomNumber, String professor) {
        this.id = id;
        this.courseCode = courseCode;
        this.roomNumber = roomNumber;
        this.professor = professor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
