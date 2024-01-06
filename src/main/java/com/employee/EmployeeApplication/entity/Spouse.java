package com.employee.EmployeeApplication.entity;

import jakarta.persistence.*;

@Entity
public class Spouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mobileNumber;
    private int age;

    @OneToOne(mappedBy = "spouse")
    private Employee employee;

    public Spouse(final String name, final String mobileNumber, final int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.age = age;
    }

    public Spouse() {

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
