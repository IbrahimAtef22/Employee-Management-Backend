package com.jobhacker.springboot.employeeapp.service;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import com.jobhacker.springboot.employeeapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> searchEmployeesByCustomParameters(
            String employeeCode,
            String employeeName,
            Date birthDate,
            String birthCity,
            Long employeeId,
            String departmentName,
            String jobTitle,
            String managerName,
            String contractType,
            String status
    ) {
        return employeeRepository.findByCustomParameters(
                employeeCode, employeeName, birthDate, birthCity, employeeId,
                departmentName, jobTitle, managerName, contractType, status
        );
    }
}
