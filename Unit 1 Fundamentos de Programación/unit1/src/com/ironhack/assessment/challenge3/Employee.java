package com.ironhack.assessment.challenge3;

import java.math.BigDecimal;

public class Employee {
    String name;
    BigDecimal salary;
    Employee supervisor;

    public Employee (String name, BigDecimal salary, Employee supervisor){
        this.name = name;
        this.salary = salary;
        this.supervisor = supervisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
}
