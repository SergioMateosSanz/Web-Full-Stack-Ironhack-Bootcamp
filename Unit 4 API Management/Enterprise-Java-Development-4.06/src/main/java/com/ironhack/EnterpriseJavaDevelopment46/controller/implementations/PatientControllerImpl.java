package com.ironhack.EnterpriseJavaDevelopment46.controller.implementations;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment46.controller.interfaces.PatientController;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment46.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class PatientControllerImpl implements PatientController {

    @Autowired
    PatientService patientService;

    @Override
    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getById(@PathVariable(name = "id") int id) {
        return patientService.findById(id);
    }

    @Override
    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> filterPatients(@RequestParam Optional<Date> startDate,
                                        @RequestParam Optional<Date> endDate,
                                        @RequestParam Optional<String> department,
                                        @RequestParam Optional<EmployeeStatus> status) {
        if ((startDate.isPresent()) && (endDate.isPresent())) {
            return patientService.findByBirthDateBetween(startDate.get(), endDate.get());
        }
        if (department.isPresent()) {
            return patientService.findByEmployeeDepartment(department.get());
        }
        if (status.isPresent()) {
            return patientService.findByEmployeeStatus(status.get());
        }
        return patientService.findAll();
    }

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
