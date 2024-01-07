package com.jobhacker.springboot.employeeapp.repository;

import com.jobhacker.springboot.employeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e " +
            "LEFT OUTER JOIN Employee m ON e.directManager.id = m.id " +
            "JOIN Department d ON e.department.id = d.id " +
            "WHERE (:empCode IS NULL OR e.code = :empCode) " +
            "AND (:empName IS NULL OR e.name = :empName) " +
            "AND (:birthdate IS NULL OR e.birthDate = :birthdate) " +
            "AND (:birthcity IS NULL OR e.birthCity = :birthcity) " +
            "AND (:empId IS NULL OR e.id = :empId) " +
            "AND (:departName IS NULL OR d.name LIKE CONCAT('%', :departName,'%')) " +
            "AND (:jobtitle IS NULL OR e.jobTitle = :jobtitle) " +
            "AND (:managerName IS NULL OR m.name = :managerName) " +
            "AND (:contractType IS NULL OR e.contractType = :contractType)" +
            "AND (:status IS NULL OR e.status = :status)")
    List<Employee> findByCustomParameters(
            @Param("empCode") String employeeCode,
            @Param("empName") String employeeName,
            @Param("birthdate") Date birthDate,
            @Param("birthcity") String birthCity,
            @Param("empId") Long employeeId,
            @Param("departName") String departmentName,
            @Param("jobtitle") String jobTitle,
            @Param("managerName") String managerName,
            @Param("contractType") String contractType,
            @Param("status") String status
    );
}
