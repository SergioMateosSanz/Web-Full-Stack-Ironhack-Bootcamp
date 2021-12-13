package com.ironhack.EnterpriseJavaDevelopment42.controller.implementations;

import com.ironhack.EnterpriseJavaDevelopment42.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces.EmployeeController;
import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment42.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        Employee employeeDatabase = employeeService.findById(id);
        employeeDTO.setId(employeeDatabase.getId());
        employeeDTO.setName(employeeDatabase.getName());
        employeeDTO.setDepartment(employeeDatabase.getDepartment());
        employeeDTO.setEmployeeStatus(employeeDatabase.getEmployeeStatus());
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
        EmployeeDTO employeeDTO = new EmployeeDTO();

        for (int i = 0; i < employeeList.size(); i++) {
            employeeDTO.setId(employeeList.get(i).getId());
            employeeDTO.setName(employeeList.get(i).getName());
            employeeDTO.setDepartment(employeeList.get(i).getDepartment());
            employeeDTO.setEmployeeStatus(employeeList.get(i).getEmployeeStatus());
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

}
