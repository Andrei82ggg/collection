package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeAlreadyAddedException;
import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

@Service
public class EmployeeService {

    private static final int SIZE = 10;

    private final Map<String, Employee> employees = new MashMap<>();

    public void addEmployee(String firstName, String lastName, double salary, int departmentId) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(key, new Employee(capitalize(firstName), capitalize(lastName), salary, departmentId));
    }

    public Employee findEmployee(String firstName, String lastName) {
        var emp = new Employee.get(makeKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String firstName, String lastName) {
        Employee removed = employees.remove(makeKey(firstName, lastName));
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }
}


    public Collection<Employee> getAll() {
        return Collections.unmodifiableList(employees.values());
    }

    private String makeKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }
}

