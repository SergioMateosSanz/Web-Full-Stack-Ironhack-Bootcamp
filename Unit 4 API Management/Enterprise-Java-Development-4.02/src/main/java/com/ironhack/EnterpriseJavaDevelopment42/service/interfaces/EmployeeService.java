package com.ironhack.EnterpriseJavaDevelopment42.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    List<Employee> findByDepartment(String department);
}
