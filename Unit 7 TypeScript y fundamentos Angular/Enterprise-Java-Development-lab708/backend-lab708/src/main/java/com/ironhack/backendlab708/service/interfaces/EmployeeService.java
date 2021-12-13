package com.ironhack.backendlab708.service.interfaces;

import com.ironhack.backendlab708.controller.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAll();
    void deleteEmployee(int id);
}
