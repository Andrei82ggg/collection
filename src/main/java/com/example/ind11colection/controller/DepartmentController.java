package com.example.ind11colection.controller;

import com.example.ind11colection.servis.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service = service;
    }
    @GetMapping("/max-salary")
    public double max(@RequestParam int departmentId){
        double maxSalary = service.maxSalary(departmentId);
        return maxSalary;
    }
}
