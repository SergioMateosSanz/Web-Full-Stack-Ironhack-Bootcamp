package com.ironhack.EnterpriseJavaDevelopment46.controller.implementations;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment46.controller.interfaces.EmployeeController;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment46.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @Override
    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getById(@PathVariable(name = "id") int id) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<Employee> employeeDatabase = employeeService.findById(id);
        employeeDTO.setId(employeeDatabase.get().getId());
        employeeDTO.setName(employeeDatabase.get().getName());
        employeeDTO.setDepartment(employeeDatabase.get().getDepartment());
        employeeDTO.setEmployeeStatus(employeeDatabase.get().getEmployeeStatus());
        return employeeDTO;
    }

    @Override
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> filterEmployees(@RequestParam Optional<EmployeeStatus> status,
                                             @RequestParam Optional<String> department) {

        List<Employee> employeeList = new ArrayList<>();

        if (status.isPresent()) {
            employeeList = employeeService.findByEmployeeStatus(status.get());
            return adaptExitInformation(employeeList);
        }
        if (department.isPresent()) {
            employeeList = employeeService.findByDepartment(department.get());
            return adaptExitInformation(employeeList);
        }
        employeeList = employeeService.findAll();
        return adaptExitInformation(employeeList);
    }

    public List<EmployeeDTO> adaptExitInformation(List<Employee> employeeList) {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO;

        for (int i = 0; i < employeeList.size(); i++) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employeeList.get(i).getId());
            employeeDTO.setName(employeeList.get(i).getName());
            employeeDTO.setDepartment(employeeList.get(i).getDepartment());
            employeeDTO.setEmployeeStatus(employeeList.get(i).getEmployeeStatus());
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

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
