package com.jobhacker.springboot.employeeapp.controller;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import com.jobhacker.springboot.employeeapp.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam(value = "employeeCode", required = false) String employeeCode,
            @RequestParam(value = "employeeName", required = false) String employeeName,
            @RequestParam(value = "birthDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
            @RequestParam(value = "birthCity", required = false) String birthCity,
            @RequestParam(value = "employeeId", required = false) Long employeeId,
            @RequestParam(value = "departmentName", required = false) String departmentName,
            @RequestParam(value = "jobTitle", required = false) String jobTitle,
            @RequestParam(value = "managerName", required = false) String managerName,
            @RequestParam(value = "contractType", required = false) String contractType,
            @RequestParam(value = "status", required = false) String status
    ) {
        List<Employee> employeeList = employeeService.searchEmployeesByCustomParameters(
                employeeCode, employeeName, birthDate, birthCity,
                employeeId, departmentName, jobTitle, managerName,
                contractType, status);

        return new ResponseEntity<>(employeeList, HttpStatus.ACCEPTED);
    }
}
