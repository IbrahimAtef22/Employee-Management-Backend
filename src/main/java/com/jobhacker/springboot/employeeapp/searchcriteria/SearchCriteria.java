package com.jobhacker.springboot.employeeapp.searchcriteria;

import lombok.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String employeeCode;
    private String employeeName;
    private LocalDate birthDate;
    private String birthCity;
    private Long employeeId;
    private String departmentName;
    private String jobTitle;
    private String managerName;
    private String contractType;
    private String status;
}
