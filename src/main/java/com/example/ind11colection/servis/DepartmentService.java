package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeServis){
        this.employeeService = employeeService;
    }
    public double sum(int deptId){
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == deptId)
                .mapToDouble(Employee :: getSalary)
                .sum();
    }
    public double maxSalary(int deptId){
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == deptId)
                .map(Employee :: getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException :: new);
    }
    public double minSalary(int deptId){
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == deptId)
                .map(Employee :: getSalary)
                .min(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException :: new);
    }
    public List<Employee> findAllByDept(int deptId){
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == deptId)
                .collect(Collectors.toList());
    }
}