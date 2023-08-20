package com.example.ind11colection.controller;
import com.example.ind11colection.exceptions.NotValidArgumentException;
import com.example.ind11colection.medal.Employee;
import com.example.ind11colection.servis.EmployeeServis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeServis servis;
    private EmployeeController service;

    public EmployeeController(EmployeeServis service){

        this.servis = service;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName){
        check(firstName, lastName);
        servis.addEmployee(firstName, lastName);
    }
    @GetMapping("/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName){
        check(firstName, lastName);
return servis.findEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public boolean remove(@RequestParam String firstName, @RequestParam String lastName){
        check(firstName, lastName);
    return servis.removeEmployee(firstName, lastName);
    }
    @GetMapping("/get")
    public Collection<Employee> getAll(){
        return service.getAll();
    }
    private void check(String... args){
        for (String arg : args){
            if (StringUtils.isAlpha(arg)){
                throw new NotValidArgumentException();
            }
        }
    }
}
