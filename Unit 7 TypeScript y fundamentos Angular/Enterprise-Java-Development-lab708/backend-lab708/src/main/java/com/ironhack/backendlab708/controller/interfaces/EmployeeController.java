package com.ironhack.backendlab708.controller.interfaces;

import com.ironhack.backendlab708.controller.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeController {

    List<EmployeeDTO> getAll();
    void deleteEmployee(int id);
}
