package com.ironhack.backendlab708.service.implementations;

import com.ironhack.backendlab708.controller.dto.EmployeeDTO;
import com.ironhack.backendlab708.model.EmployeeEntity;
import com.ironhack.backendlab708.repository.EmployeeRepository;
import com.ironhack.backendlab708.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAll() {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        for (EmployeeEntity employee: employeeEntityList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeDTO.setOfficeNumber(employee.getOfficeNumber());
            employeeDTO.setPosition(employee.getPosition());
            employeeDTO.setManager(employee.getManager());
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

    @Override
    public void deleteEmployee(int id) {

        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

        if (!optionalEmployeeEntity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Employee not found");
        }

        employeeRepository.delete(optionalEmployeeEntity.get());
    }
}
