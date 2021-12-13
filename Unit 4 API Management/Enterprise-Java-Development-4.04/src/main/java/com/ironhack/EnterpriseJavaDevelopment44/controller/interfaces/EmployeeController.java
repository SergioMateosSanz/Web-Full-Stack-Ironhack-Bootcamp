package com.ironhack.EnterpriseJavaDevelopment44.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;

import java.util.Optional;

public interface EmployeeController {

    Employee store(EmployeeDTO employeeDTO);
    void update(int id, EmployeeDTO employeeDTO);
}
