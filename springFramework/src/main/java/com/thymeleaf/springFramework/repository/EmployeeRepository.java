package com.thymeleaf.springFramework.repository;

import com.thymeleaf.springFramework.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
