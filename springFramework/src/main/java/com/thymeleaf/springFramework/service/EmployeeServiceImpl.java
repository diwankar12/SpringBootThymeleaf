package com.thymeleaf.springFramework.service;

import com.thymeleaf.springFramework.model.Employee;
import com.thymeleaf.springFramework.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;



    @Override
    public List<Employee> getAllEmployees() {
      return employeeRepository.findAll() ;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id) {

        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            return emp.get();
        } else {
            throw new RuntimeException("Employee is not present");
        }
    }

    @Override
    public void deleteEmployee(long id) {

        employeeRepository.delete(employeeRepository.findById(id).get());
    }
}
