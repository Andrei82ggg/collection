package com.example.ind11colection.servis;

import com.example.ind11colection.medal.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

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
        employeeServis.getAll().stream()
                .filter(employee ->  employee.getDepartment() == deptId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o));
    }
}
