package com.jobhacker.springboot.employeeapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "birth_city")
    private String birthCity;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direct_manager")
    private Employee directManager;

    @Column(name = "contract_type", nullable = false)
    private String contractType;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "depart_id", nullable = false, referencedColumnName = "id")
    private Department department;


}
