package com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientController {

    Patient getById(int id);
    List<Patient> filterPatients(Optional<Date> startDate, Optional<Date> endDate,
                                 Optional<String> department,
                                 Optional<EmployeeStatus> status);
}
