package com.example.ind11colection.controller;
import com.example.ind11colection.medal.Employee;
import com.example.ind11colection.servis.EmployeeServis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeServis servis;
    public EmployeeController(EmployeeServis servis){
        this.servis = servis;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName){
    servis.addEmployee(firstName, lastName);
    }
    @GetMapping("/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName){
return servis.findEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public boolean remove(@RequestParam String firstName, @RequestParam String lastName){
    return servis.removeEmployee(firstName, lastName);
    }
}
