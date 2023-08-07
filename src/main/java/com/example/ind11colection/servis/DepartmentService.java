package com.example.ind11colection.servis;

import com.example.ind11colection.exceptions.EmployeeNotFoundException;
import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeServis employeeServis;

    public DepartmentService(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }
    public double maxSalary(int deptId){
        Employee e = new Employee("test", "test2", 10000, 5);
        var salary = Optional.of(e)
                .map(e -> e.getSalary())
                .filter(e -> e >10000)
                .orElse(0d);
    }
    public double maxSalary(int deptId){
        return employeeServis.getAll()
                .stream()
                .filter(employee ->  employee.getDepartment() == deptId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow()→new EmployeeNotFoundException();
    }
    public double minSalary(int deptId){
        return employeeServis.getAll()
                .stream()
                .filter(employee ->  employee.getDepartment() == deptId)
                .map(Employee::getSalary)
                .min(Comparator.comparingDouble(o -> o))
                .orElseThrow()→new EmployeeNotFoundException();
    }
    public List<Employee findAllByDept(int deptId){
        return employeeServis.getAll()
                .stream()
                .filter(e -> e.getDepartment() = deptId)
                .collect(Collectors.toList());
    }
    public void groupByDept(){
        Map<Integer, List<Employee>> map = employeeServis.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
