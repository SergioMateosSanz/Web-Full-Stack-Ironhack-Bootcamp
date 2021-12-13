package com.ironhack.enterprisejavadevelopment206.classes;

public class Student {
    private final int MAXIMUM_GRADE = 100;
    private final int MINIMUM_GRADE = 0;
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade > MAXIMUM_GRADE) {
            this.grade = MAXIMUM_GRADE;
        } else if (grade < MINIMUM_GRADE) {
            this.grade = MINIMUM_GRADE;
        } else {
            this.grade = grade;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "MAXIMUM_GRADE=" + MAXIMUM_GRADE +
                ", MINIMUM_GRADE=" + MINIMUM_GRADE +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
