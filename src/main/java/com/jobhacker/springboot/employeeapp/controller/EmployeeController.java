package com.jobhacker.springboot.employeeapp.controller;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import com.jobhacker.springboot.employeeapp.searchcriteria.SearchCriteria;
import com.jobhacker.springboot.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> searchEmployees(@ModelAttribute SearchCriteria criteria) {
        List<Employee> employeeList = employeeService.searchEmployeesByCustomParameters(criteria);
        return new ResponseEntity<>(employeeList, HttpStatus.ACCEPTED);
    }

}
