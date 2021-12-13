package com.ironhack.EnterpriseJavaDevelopment46.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeController {

    EmployeeDTO getById(int id);
    List<EmployeeDTO> filterEmployees(Optional<EmployeeStatus> employeeStatus, Optional<String> department);
    Employee store(EmployeeDTO employeeDTO);
    void update(int id, EmployeeDTO employeeDTO);
}
