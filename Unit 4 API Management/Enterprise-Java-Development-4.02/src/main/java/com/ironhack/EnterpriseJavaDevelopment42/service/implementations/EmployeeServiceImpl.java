package com.ironhack.EnterpriseJavaDevelopment42.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment42.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment42.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus) {

        return employeeRepository.findByEmployeeStatus(employeeStatus);
    }

    @Override
    public List<Employee> findByDepartment(String department) {

        return employeeRepository.findByDepartment(department);
    }
}
