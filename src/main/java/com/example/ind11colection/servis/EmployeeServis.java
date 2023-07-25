package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeStorageIsFullException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServis {

    private static final int SIZE = 10;

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(){
    if (employees.size() == SIZE){
        throw new EmployeeStorageIsFullException();
    }
    }
    public void findEmployee(){

    }
    public void removeEmployee(){

    }
}
