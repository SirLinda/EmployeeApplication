package com.employee.EmployeeApplication.entity;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String clientName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project(final String name, final String clientName) {
        this.name = name;
        this.clientName = clientName;
    }

    public Project() {

    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }
}
