package com.jobhacker.springboot.employeeapp.service;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import com.jobhacker.springboot.employeeapp.repository.EmployeeRepository;
import com.jobhacker.springboot.employeeapp.searchcriteria.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> searchEmployeesByCustomParameters(SearchCriteria criteria) {
        return employeeRepository.findEmployeesByCriteria(criteria);
    }


}
