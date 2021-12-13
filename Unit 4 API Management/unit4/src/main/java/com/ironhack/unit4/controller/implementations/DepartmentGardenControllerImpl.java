package com.ironhack.unit4.controller.implementations;

import com.ironhack.unit4.controller.dto.DepartmentGardenDTO;
import com.ironhack.unit4.controller.interfaces.DepartmentGardenController;
import com.ironhack.unit4.service.interfaces.DepartmentGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DepartmentGardenControllerImpl implements DepartmentGardenController {

    @Autowired
    DepartmentGardenService departmentGardenService;

    @Override
    @PostMapping("/departmentsgarden")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentGardenDTO store(@RequestBody @Valid DepartmentGardenDTO departmentGardenDTO) {
        return departmentGardenService.store(departmentGardenDTO);
    }
}
