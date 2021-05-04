package com.thymeleaf.springFramework.service;

import com.thymeleaf.springFramework.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees() ;
    void saveEmployee(Employee employee);
    Employee updateEmployee(Long id) ;
    void deleteEmployee(long id);
    Page<Employee> findPaginated(int pageNo,int pageSize);

}
