package com.ironhack.EnterpriseJavaDevelopment44.controller.dto;

import javax.validation.constraints.Min;
import java.util.Date;

public class PatientDTO {

    private String name;
    private Date dateOfBirth;
    @Min(value = 0)
    private int admittedBy;

    public PatientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(int admittedBy) {
        this.admittedBy = admittedBy;
    }
}
