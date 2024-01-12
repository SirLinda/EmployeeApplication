package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
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

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        System.out.println("Fetching Projects in Service class");
        Set<Project> projects = employee.getProjects();

        for(Project project: projects){
            System.out.println(project.getClientName());
        }
        return employee;
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
