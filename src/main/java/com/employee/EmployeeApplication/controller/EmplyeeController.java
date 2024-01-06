package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmplyeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable int id,
                               @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
