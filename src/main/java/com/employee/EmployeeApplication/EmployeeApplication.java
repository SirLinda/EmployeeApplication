package com.employee.EmployeeApplication;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.entity.Spouse;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService){
		return(args) -> {
			Address address1 = new Address("Line 1", "Line 2",
					"2000", "Johannesburg", "Gauteng",
					"South Africa");
			Project project1 = new Project("name1", "client1");
			Spouse spouse1 = new Spouse("spouse name1", "0828492493",24);
			Employee employee = new Employee("Employee1","City1");

			employee.addProject(project1);
			employee.addAddress(address1);
			employee.setSpouse(spouse1);

			employeeService.createEmployee(employee);

			System.out.println("Getting an employee");
			Employee employee1 = employeeService.getEmployee(1);
		};
	}
}
