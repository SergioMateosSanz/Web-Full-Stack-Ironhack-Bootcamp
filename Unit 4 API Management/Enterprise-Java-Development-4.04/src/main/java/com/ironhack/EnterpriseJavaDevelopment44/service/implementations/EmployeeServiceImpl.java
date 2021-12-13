package com.ironhack.EnterpriseJavaDevelopment44.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment44.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment44.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee store(EmployeeDTO employeeDTO) {
        Optional<Employee> databaseEmployee = employeeRepository.findById(employeeDTO.getId());
        if (databaseEmployee.isPresent()) {
            return null;
        } else {
            Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getDepartment(),
                    employeeDTO.getName(), employeeDTO.getEmployeeStatus());
            return employeeRepository.save(employee);
        }
    }

    @Override
    public void update(int id, EmployeeDTO employeeDTO) {
        Optional<Employee> databaseEmployee = employeeRepository.findById(id);
        if (databaseEmployee.isPresent()) {
            /*Employee employee = new Employee(databaseEmployee.get().getId(), employeeDTO.getDepartment(),
                    databaseEmployee.get().getName(), employeeDTO.getEmployeeStatus());*/
            Employee employee = new Employee();
            employee.setId(databaseEmployee.get().getId());
            if (employeeDTO.getDepartment() == null) {
                employee.setDepartment(databaseEmployee.get().getDepartment());
            } else {
                employee.setDepartment(employeeDTO.getDepartment());
            }
            employee.setName(databaseEmployee.get().getName());
            if (employeeDTO.getEmployeeStatus() == null) {
                employee.setEmployeeStatus(databaseEmployee.get().getEmployeeStatus());
            } else {
                employee.setEmployeeStatus(employeeDTO.getEmployeeStatus());
            }
            employeeRepository.save(employee);
        }
    }
}
