package com.ironhack.EnterpriseJavaDevelopment46.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment46.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment46.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus) {

        return employeeRepository.findByEmployeeStatus(employeeStatus);
    }

    @Override
    public List<Employee> findByDepartment(String department) {

        return employeeRepository.findByDepartment(department);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee store(EmployeeDTO employeeDTO) {
        Optional<Employee> databaseEmployee = employeeRepository.findById(employeeDTO.getId());
        if (databaseEmployee.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Resource already exists");
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
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Resource with Id " + id + " not found");
        }
    }
}
