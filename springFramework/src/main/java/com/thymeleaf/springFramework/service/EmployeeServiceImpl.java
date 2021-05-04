package com.thymeleaf.springFramework.service;

import com.thymeleaf.springFramework.model.Employee;
import com.thymeleaf.springFramework.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return  employeeRepository.findAll(pageable);

    }
}
