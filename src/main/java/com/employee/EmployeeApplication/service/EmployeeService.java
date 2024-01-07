package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(101, "First Employee", "Johannesburg"),
                new Employee(102, "Second Employee", "Cape Town")));

    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
//        return employeeList;
        return employeeRepository.findAll();
    }
    public Employee getEmployee(int id){
        /*return employeeList.stream()
                .filter(employee -> (employee.getEmployeeId() == id))
                        .findFirst().get();*/
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
    public  void createEmployee(Employee employee){
        //employeeList.add(employee);
        ArrayList<Address> addressArrayList = new ArrayList<>();

        for(Address address : employee.getAddresses()){
            addressArrayList.add(new Address(address.getLine1(),
                    address.getLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getProvince(),
                    address.getCountry(),
                    employee));
        }

        employee.setAddresses(addressArrayList);

        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){

        /*for(Employee employee1 : employeeList){
            if (employee1.getEmployeeId() == employee.getEmployeeId()){
                employee1.setEmployeeName(employee.getEmployeeName());
                employee1.setEmployeeCity(employee.getEmployeeCity());

                break;
            }
        }*/

        employeeRepository.save(employee);



    }

    public void deleteEmployee(int id){
        /*Iterator<Employee> iterator = employeeList.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();

            if (employee.getEmployeeId() == id){
                iterator.remove();
                break;
            }
        }*/
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
