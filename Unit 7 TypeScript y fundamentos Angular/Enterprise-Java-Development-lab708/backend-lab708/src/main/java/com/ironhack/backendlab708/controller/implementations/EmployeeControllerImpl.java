package com.ironhack.backendlab708.controller.implementations;

import com.ironhack.backendlab708.controller.dto.EmployeeDTO;
import com.ironhack.backendlab708.controller.interfaces.EmployeeController;
import com.ironhack.backendlab708.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAll() {

        return employeeService.getAll();
    }

    @Override
    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}
