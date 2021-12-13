package com.ironhack.EnterpriseJavaDevelopment44.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findById(int id);
    Employee store(EmployeeDTO employeeDTO);
    void update(int id, EmployeeDTO employeeDTO);
}
