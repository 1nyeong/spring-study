package com.study.springboot202210h.repository;

import com.study.springboot202210h.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmployeeDto employeeDto);
}
