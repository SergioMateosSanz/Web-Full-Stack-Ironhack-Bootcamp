package com.ironhack.unit4.service.implementations;

import com.ironhack.unit4.controller.dto.DepartmentGardenDTO;
import com.ironhack.unit4.model.DepartmentGarden;
import com.ironhack.unit4.repository.DepartmentGardenRepository;
import com.ironhack.unit4.service.interfaces.DepartmentGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepartmentGardenServiceImpl implements DepartmentGardenService {

    @Autowired
    DepartmentGardenRepository departmentGardenRepository;

    @Override
    public DepartmentGardenDTO store(DepartmentGardenDTO departmentGardenDTO) {

        if (departmentGardenDTO.getName() == "") {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessed information");
        }
        DepartmentGarden departmentGarden = new DepartmentGarden(departmentGardenDTO.getName());
        departmentGardenRepository.save(departmentGarden);
        DepartmentGardenDTO departmentGardenDTOExit = new DepartmentGardenDTO();
        departmentGardenDTOExit.setId(departmentGarden.getId());
        departmentGardenDTOExit.setName(departmentGarden.getName());

        return departmentGardenDTOExit;
    }
}
