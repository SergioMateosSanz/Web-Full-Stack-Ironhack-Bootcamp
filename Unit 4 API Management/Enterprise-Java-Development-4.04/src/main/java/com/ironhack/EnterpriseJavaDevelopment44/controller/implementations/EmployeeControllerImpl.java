package com.ironhack.EnterpriseJavaDevelopment44.controller.implementations;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment44.controller.interfaces.EmployeeController;
import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment44.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @Override
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee store(@RequestBody @Valid EmployeeDTO employeeDTO) {

        return employeeService.store(employeeDTO);
    }

    @Override
    @PatchMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") int id,
                           @RequestBody @Valid EmployeeDTO employeeDTO) {
        employeeService.update(id, employeeDTO);
    }
}
