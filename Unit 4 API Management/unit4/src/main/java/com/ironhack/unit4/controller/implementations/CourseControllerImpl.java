package com.ironhack.unit4.controller.implementations;

import com.ironhack.unit4.model.Course;
import com.ironhack.unit4.repository.CourseRepository;
import com.ironhack.unit4.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseControllerImpl implements com.ironhack.unit4.controller.interfaces.CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @Override
    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    @GetMapping("/courses/{code}")
    public Course getById(@PathVariable(name = "code") String code) {
        return courseRepository.findById(code).get();
    }

    @Override
    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course store(@RequestBody @Valid Course course) {
        return courseService.store(course);
    }

    @Override
    @PutMapping("/courses/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "code") String code, @RequestBody @Valid Course course) {
        courseService.update(code, course);
    }
}
