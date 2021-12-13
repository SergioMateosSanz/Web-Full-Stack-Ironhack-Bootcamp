package com.ironhack.lab106;

/**
 * Employee child that have a salary limit of 20000
 * @author Sergio Mateos Sanz
 */
public class Intern extends Employee {
    private final double SALARY_LIMIT = 20000;

    public Intern(String name, double salary) {
        super(name, salary);
        if (salary > SALARY_LIMIT) {
            super.setSalary(SALARY_LIMIT);
            System.out.println(super.getName() + " salary limit exceed. Salary set to " + SALARY_LIMIT);
        }
    }

    @Override
    public void setSalary(double salary) {
        if (salary <= SALARY_LIMIT) {
            super.setSalary(salary);
        } else {
            super.setSalary(SALARY_LIMIT);
            System.out.println(super.getName() + " input salary exceed salary limit. Updated with Salary limit");
        }
    }
}
