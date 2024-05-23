package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empName;
    private String empNumber;

    public Employee() {

    }

    public Employee(Integer id, String empName, String empNumber) {
        this.id = id;
        this.empName = empName;
        this.empNumber = empNumber;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(empName, employee.empName) && Objects.equals(empNumber, employee.empNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empName, empNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empNumber='" + empNumber + '\'' +
                '}';
    }
}
