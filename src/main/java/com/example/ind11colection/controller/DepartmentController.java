package com.example.ind11colection.controller;

import com.example.ind11colection.medal.Employee;
import com.example.ind11colection.servis.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service){

        this.service = service;
    }
    @GetMapping("/{deptId}/salary/sum")
    public double sumByDept(@PathVariable int deptId){
    return service.sum(deptId);
    }
    @GetMapping("{deptId}/salary/max")
    public double max(@PathVariable int deptId){
        double maxSalary = service.maxSalary(deptId);
        return maxSalary;
    }
    @GetMapping("{deptId}/salary/min")
    public double min(@PathVariable int deptId){
        return service.minSalary(deptId);
    }
    @GetMapping("{deptId}/employees")
    public Collection<Employee> byDept(@PathVariable int deptId){
        return service.findAllByDept(deptId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all(){
        return service.groupByDept();
    }
}
