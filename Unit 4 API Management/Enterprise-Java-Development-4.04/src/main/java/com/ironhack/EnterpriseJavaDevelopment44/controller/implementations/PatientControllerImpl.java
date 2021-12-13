package com.ironhack.EnterpriseJavaDevelopment44.controller.implementations;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment44.controller.interfaces.PatientController;
import com.ironhack.EnterpriseJavaDevelopment44.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment44.service.interfaces.EmployeeService;
import com.ironhack.EnterpriseJavaDevelopment44.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class PatientControllerImpl implements PatientController {

    @Autowired
    PatientService patientService;

    @Override
    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient store(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.store(patientDTO);
    }

    @Override
    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") int id,
                       @RequestBody @Valid PatientDTO patientDTO) {
        patientService.update(id, patientDTO);
    }

}
