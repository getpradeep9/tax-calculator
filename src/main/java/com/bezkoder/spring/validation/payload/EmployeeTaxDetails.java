package com.bezkoder.spring.validation.payload;

public class EmployeeTaxDetails {


    private String employeeCode;
    private String firstName;
    private String lastName;
    private float yearlySalary;

    private float taxAmount;

    private float cessAmount;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(float yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public float getCessAmount() {
        return cessAmount;
    }

    public void setCessAmount(float cessAmount) {
        this.cessAmount = cessAmount;
    }
}
