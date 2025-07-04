package com.example.spring.day3.Services;

import com.example.spring.day3.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Helloservices {

    List<Employee> empList = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Prasanth", "Trainer"),
                    new Employee(2, "Yuvaraj", "Faculty")
            )
    );

    public void addEmployee(Employee emp) {
        empList.add(emp);
    }

    public String getmethod() {
        return "get method called successfully";
    }

    public String Putmethod() {
        return "put method called";
    }

    public String Deletemethod() {
        return "delete method called ";
    }

    public List<Employee> getAllEmployees() {
        return empList;
    }
}