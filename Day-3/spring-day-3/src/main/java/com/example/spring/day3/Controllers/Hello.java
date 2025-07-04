package com.example.spring.day3.Controllers;

import com.example.spring.day3.Models.Employee;
import com.example.spring.day3.Services.Helloservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Hello {

    @Autowired
    Helloservices hel;

    @GetMapping("/api")
    public String getGreetings() {
        return hel.getmethod();
    }

    @PutMapping("/put")
    public String Putmethod() {
        return hel.Putmethod();
    }

    @DeleteMapping("/del")
    public String deletegreet() {
        return hel.Deletemethod();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return hel.getAllEmployees();
    }

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee emp) {
        hel.addEmployee(emp);
        return "Employee added successfully";
    }
}