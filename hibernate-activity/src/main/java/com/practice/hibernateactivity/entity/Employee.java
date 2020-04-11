package com.practice.hibernateactivity.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "company")
    String company;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee [ FirstName: " + firstName + ", LastName: " + lastName + ", company: " + company + " ]";
    }

}
