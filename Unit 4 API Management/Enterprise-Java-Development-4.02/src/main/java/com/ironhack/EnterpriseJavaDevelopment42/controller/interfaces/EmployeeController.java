package com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeController {

    EmployeeDTO getById(int id);
    List<EmployeeDTO> filterEmployees(Optional<EmployeeStatus> employeeStatus, Optional<String> department);
}
