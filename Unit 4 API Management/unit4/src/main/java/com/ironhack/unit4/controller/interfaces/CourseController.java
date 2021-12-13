package com.ironhack.unit4.controller.interfaces;

import com.ironhack.unit4.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseController {

    List<Course> getAll();
    Course getById(String code);
    Course store(Course course);
    void update(String code, Course course);
}
