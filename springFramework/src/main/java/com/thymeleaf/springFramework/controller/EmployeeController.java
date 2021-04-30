package com.thymeleaf.springFramework.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thymeleaf.springFramework.model.Employee;
import com.thymeleaf.springFramework.service.EmployeeService;
import com.thymeleaf.springFramework.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

@Controller
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String getEmployeeList(Model model){

        model.addAttribute("employeesList",employeeService.getAllEmployees());

        return "index" ;
    }


    @GetMapping("/showemployeeForm")
    public String employeeForm(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee" ;

    }

   @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
   }

    @GetMapping("/showFormUpdate/{id}")
    public String updateEmployee( @PathVariable(value = "id") long id,Model model){
        Employee employee = employeeService.updateEmployee(id);
        model.addAttribute("employee" , employee);
        return "update_employee" ;
    }

   @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id ){

        employeeService.deleteEmployee(id);
       return "redirect:/";

   }

}
