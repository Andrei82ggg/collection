package com.example.ind11colection.controller;
import com.example.ind11colection.medal.Employee;
import com.example.ind11colection.servis.EmployeeService;
import com.example.ind11colection.servis.EmployeeServis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService servis;
    public EmployeeController(EmployeeService servis){
        this.servis = servis;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName,
                    @RequestParam String lastName,
                    @RequestParam double salary,
                    @RequestParam int departmentId){
    servis.addEmployee(firstName, lastName, salary, departmentId);
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
