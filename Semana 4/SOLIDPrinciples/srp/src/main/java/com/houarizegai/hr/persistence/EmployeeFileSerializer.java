package com.houarizegai.hr.persistence;

import com.houarizegai.hr.personnel.Employee;

public class EmployeeFileSerializer {

    public StringBuilder serialize(Employee employee) {
        StringBuilder sb = new StringBuilder();

        sb.append("### EMPLOYEE RECORD ####");
        sb.append(System.lineSeparator());
        sb.append("NAME: ");
        sb.append(employee.getFirstName() + " " + employee.getLastName());
        sb.append(System.lineSeparator());
        sb.append("POSITION: ");
        sb.append(employee.getClass().getTypeName());
        sb.append(System.lineSeparator());
        sb.append("EMAIL: ");
        sb.append(employee.getEmail());
        sb.append(System.lineSeparator());
        sb.append("MONTHLY WAGE: ");
        sb.append(employee.getMonthlyIncome());
        sb.append(System.lineSeparator());

        return sb;
    }
}