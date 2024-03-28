package com.bezkoder.spring.validation.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeDetails {

    @NotBlank(message = "EmployeeID" + " is required.")
    @NotNull(message = "EmployeeID " + "cannot " + " be " + "null.")
    @NotEmpty(message = "EmployeeID" + " is required.")
    @JsonProperty("EmployeeID")
    private String employeeID;

    @NotBlank(message = "FirstName" + " is required.")
    @NotNull(message = "FirstName" + " " + "cannot" + " be " + "null.")
    @NotEmpty(message = "FirstName" + " " + "cannot" + " be " + "empty.")
    @JsonProperty("FirstName")
    private String firstName;

    @NotBlank(message = "LastName" + " is required.")
    @NotNull(message = "LastName" + " cannot" + " be " + "null")
    @NotEmpty(message = "LastName" + " is required.")
    @JsonProperty("LastName")
    private String lastName;

    @NotEmpty(message = "The email is required.")
    @NotNull(message = "The" + " email is required.")
    @NotBlank(message = "The" + " email is required.")
    @Email(message = "The email is not a valid email.")
    @JsonProperty("Email")
    private String email;

    @NotNull(message = "The age is required.")
    @Min(value = 1, message = "The " + "salary" + " is " + "required")
    @JsonProperty("Salary")
    private int salary;

    @NotNull(message = "The" + " DOJ date is " + "required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("DOJ")
    private Date doj;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
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
}
