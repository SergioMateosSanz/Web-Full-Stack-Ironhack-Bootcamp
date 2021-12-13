package com.ironhack.unit4.service.implementations;

import com.ironhack.unit4.model.Course;
import com.ironhack.unit4.repository.CourseRepository;
import com.ironhack.unit4.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course store(Course course) {
        Optional<Course> databaseCourse = courseRepository.findById(course.getCourseCode());
        if (databaseCourse.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Resource already exists");
        } else {
            return courseRepository.save(course);
        }
    }

    @Override
    public void update(String code, Course course) {
/*        Optional<Course> databaseCourse = courseRepository.findById(code);
        if (databaseCourse.isPresent()) {
            course.setCourseCode(code);
            courseRepository.save(course);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Resource with Id " + code + " not found");
        }*/
        courseRepository.findById(code).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Resource with Id " + code + " not found"));
        course.setCourseCode(code);
        courseRepository.save(course);
    }
}
