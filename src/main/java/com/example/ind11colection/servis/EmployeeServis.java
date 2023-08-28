package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeAlreadyAddedException;
import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServis {

    private static final int SIZE = 10;

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, new Employee(capitalize(firstName), capitalize(lastName)));
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

    public Collection<Employee> getAll() {
        return Collections.unmodifiableList(employees.values());
    }
    private String makeKey(String firstName, String lastName){
        return (firstName+ "_" + lastName).toLowerCase();
    }
}

