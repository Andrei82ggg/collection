package com.example.ind11colection.medal;

import java.util.Objects;

public class Employee {
    private String firstName;

    public Employee(String test, String test2, double salary, int department) {
        this.salary = salary;
        this.department = department;
    }

    private String lastName;

    private double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, department);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    private int department;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
