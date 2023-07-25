package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeAlreadyAddedException;
import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServis {

    private static final int SIZE = 10;

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (emp.equals(employee)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public boolean removeEmployee(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        for (Employee e : employees) {
            if (e.equals(employee)) {
                employees.remove(e);
                return true;
            }
        }
        throw new EmployeeNotFoundException();
    }
}

