package com.ironhack.EnterpriseJavaDevelopment46.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    List<Employee> findByDepartment(String department);

    Optional<Employee> findById(int id);
    Employee store(EmployeeDTO employeeDTO);
    void update(int id, EmployeeDTO employeeDTO);
}
