package com.ironhack.enterprisejavadevelopment206.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Test
    void setGrade_CorrectSet_PositiveNumber() {
        student.setGrade(0);
        if (student.getGrade() != 0) {
            fail("Grade is not set");
        }
        student.setGrade(33);
        if (student.getGrade() != 33) {
            fail("Grade is not set");
        }
        student.setGrade(100);
        if (student.getGrade() != 100) {
            fail("Grade is not set");
        }
    }

    @Test
    void setGrade_MaximumSet_PositiveNumberGreaterThanMaximum() {
        student.setGrade(101);
        if (student.getGrade() != 100) {
            fail("Grade is not set");
        }
        student.setGrade(127);
        if (student.getGrade() != 100) {
            fail("Grade is not set");
        }
    }

    @Test
    void setGrade_MinimumSet_NegativeNumberLowerThanMinimum() {
        student.setGrade(-1);
        if (student.getGrade() != 0) {
            fail("Grade is not set");
        }
        student.setGrade(-128);
        if (student.getGrade() != 0) {
            fail("Grade is not set");
        }
    }
}