package com.ironhack.unit4.service.interfaces;

import com.ironhack.unit4.model.Course;

public interface CourseService {
    Course store(Course course);
    void update(String code, Course course);
}
