package com.thymeleaf.springFramework.service;

import com.thymeleaf.springFramework.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees() ;
    void saveEmployee(Employee employee);
    Employee updateEmployee(Long id) ;
    void deleteEmployee(long id);

}
