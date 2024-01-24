package com.jobhacker.springboot.employeeapp.repository;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import com.jobhacker.springboot.employeeapp.entity.QDepartment;
import com.jobhacker.springboot.employeeapp.entity.QEmployee;
import com.jobhacker.springboot.employeeapp.searchcriteria.SearchCriteria;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee> {

    default List<Employee> findEmployeesByCriteria(SearchCriteria criteria){
        BooleanBuilder builder = new BooleanBuilder();
        QEmployee employee = QEmployee.employee;
        QEmployee manager = QEmployee.employee.directManager;
        QDepartment department = QDepartment.department;

        // Using the criteria object to build the predicate
        if (criteria.getEmployeeCode() != null) {
            builder.and(employee.code.eq(criteria.getEmployeeCode()));
        }
        if (criteria.getEmployeeName() != null) {
            builder.and(employee.name.eq(criteria.getEmployeeName()));
        }
        if (criteria.getBirthDate() != null) {
            builder.and(employee.birthDate.loe(criteria.getBirthDate()));
        }
        if (criteria.getBirthCity() != null) {
            builder.and(employee.birthCity.eq(criteria.getBirthCity()));
        }
        if (criteria.getEmployeeId() != null) {
            builder.and(employee.id.eq(criteria.getEmployeeId()));
        }
        if (criteria.getDepartmentName() != null) {
            builder.and(department.name.containsIgnoreCase(criteria.getDepartmentName()));
        }
        if (criteria.getJobTitle() != null) {
            builder.and(employee.jobTitle.eq(criteria.getJobTitle()));
        }
        if (criteria.getManagerName() != null) {
            builder.and(manager.name.eq(criteria.getManagerName()));
        }
        if (criteria.getContractType() != null) {
            builder.and(employee.contractType.eq(criteria.getContractType()));
        }
        if (criteria.getStatus() != null) {
            builder.and(employee.status.eq(criteria.getStatus()));
        }

        // Use the predicate to query the repository
        return (List<Employee>) findAll(builder);
    }
}
