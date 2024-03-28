package com.bezkoder.spring.validation.controller;

import com.bezkoder.spring.validation.payload.EmployeeDetails;
import com.bezkoder.spring.validation.payload.EmployeeTaxDetails;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api" + "/employee")
public class EmployeeController {


    List<EmployeeDetails> employeeDetailsList = new ArrayList();
    List<EmployeeTaxDetails> employeeTaxDetailsList = new ArrayList<>();

    @PostMapping("/store")
    public ResponseEntity<?> registerUser(@Valid @RequestBody EmployeeDetails employeeDetails) {
        employeeDetailsList.add(employeeDetails);
        System.out.println(employeeDetails.getDoj());
        LocalDate doj = employeeDetails.getDoj().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endOfMonth = doj.withDayOfMonth(doj.lengthOfMonth());
        long reaminingDays = DAYS.between(doj, endOfMonth) + 1;
        System.out.println("remaining " + "days = " + reaminingDays);
        int noOfDaysInTheMonth = doj.lengthOfMonth();
        float currentMonthSalary = (employeeDetails.getSalary() / noOfDaysInTheMonth) * reaminingDays;
        System.out.println("CurrentMonth salary = " + currentMonthSalary);
        int remainingMonths = 0;
        switch (doj.getMonth()) {
            case APRIL ->
                    remainingMonths = 11;
            case MAY ->
                    remainingMonths = 10;
            case JUNE ->
                    remainingMonths = 9;
            case JULY ->
                    remainingMonths = 8;
            case AUGUST ->
                    remainingMonths = 7;
            case SEPTEMBER ->
                    remainingMonths = 6;
            case OCTOBER ->
                    remainingMonths = 5;
            case NOVEMBER ->
                    remainingMonths = 4;
            case DECEMBER ->
                    remainingMonths = 3;
            case JANUARY ->
                    remainingMonths = 2;
            case FEBRUARY ->
                    remainingMonths = 1;
            case MARCH ->
                    remainingMonths = 0;


        }
        int remainingMonthsSalary = remainingMonths * employeeDetails.getSalary();
        float finalSalary = remainingMonthsSalary + currentMonthSalary;
        float finalTax = 0.0f;
        float cess = 0.0f;
        if (finalSalary <= 250000) {
            finalTax = 0;
        }
        if (finalSalary > 250000 && finalSalary <= 500000) {
            float fivePercentTaxableSal = finalSalary - 250000;
            finalTax = fivePercentTaxableSal * 5 / 100;
        }
        if (finalSalary > 500000 && finalSalary <= 1000000) {
            float tenPercentTaxableSalary = finalSalary - 500000;
            finalTax = tenPercentTaxableSalary * 10 / 100 + (250000 * 5 / 100);


        }
        if (finalSalary > 1000000) {
            float twentyPercentSalary = finalSalary - 1000000;
            finalTax = twentyPercentSalary * 20 / 100 + 500000 * 10 / 100 + 250000 * 5 / 100;
        }
        if (finalSalary > 2500000) {
            cess = finalSalary * 2 / 100;
        }
        EmployeeTaxDetails employeeTaxDetails = new EmployeeTaxDetails();
        employeeTaxDetails.setEmployeeCode(employeeDetails.getEmployeeID());
        employeeTaxDetails.setFirstName(employeeDetails.getFirstName());
        employeeTaxDetails.setLastName(employeeDetails.getLastName());
        employeeTaxDetails.setYearlySalary(employeeDetails.getSalary() * 12);
        employeeTaxDetails.setTaxAmount(finalTax);
        employeeTaxDetails.setCessAmount(cess);
        employeeTaxDetailsList.add(employeeTaxDetails);
        return new ResponseEntity<>("Employee joined Successfully!", HttpStatus.OK);
    }

    @GetMapping("/tax")
    ResponseEntity<?> getAllEmployeeTaxDetails() {
        return new ResponseEntity<>(employeeTaxDetailsList, HttpStatus.OK);
    }

}
