package com.ironhack.angularexerciseclasses.controller.implementations;

import com.ironhack.angularexerciseclasses.controller.dto.ClassesDTO;
import com.ironhack.angularexerciseclasses.controller.interfaces.ClassesController;
import com.ironhack.angularexerciseclasses.service.intefaces.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class ClassesControllerImpl implements ClassesController {

    @Autowired
    private ClassesService classesService;

    @Override
    @GetMapping("/classes")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassesDTO> getAll() {

        return classesService.getAll();
    }
}
