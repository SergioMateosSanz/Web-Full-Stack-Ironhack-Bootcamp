package com.ironhack.EnterpriseJavaDevelopment46.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface PatientController {

    Patient getById(int id);

    List<Patient> filterPatients(Optional<Date> startDate, Optional<Date> endDate,
                                 Optional<String> department,
                                 Optional<EmployeeStatus> status);

    Patient store(PatientDTO patientDTO);

    void update(int id, PatientDTO patientDTO);
}
