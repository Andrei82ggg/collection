package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeAlreadyAddedException;
import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServis {

    private static final int SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        var employee = new Employee(firstName, lastName);
        employees.put(key, employee);
    }

    private String makeKey(String firstName, String lastName) {
    }

    public Employee findEmployee(String firstName, String lastName) {
        var emp = employees.get(makeKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String firstName, String lastName) {
        Employee removed = employees.remove(makeKey(firstName, lastName));
        if (removed == null) {
            throw new EmployeeNotFoundException();
            return true;
        }


        public Collection<Employee> getAll(){
            return employees.values();
        }
        private String makeKey(String firstName, String lastName){
            return (firstName + "_" + lastName).toLowerCase();
        }
    }
}



