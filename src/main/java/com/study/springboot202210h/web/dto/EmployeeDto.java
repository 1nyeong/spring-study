package com.study.springboot202210h.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
