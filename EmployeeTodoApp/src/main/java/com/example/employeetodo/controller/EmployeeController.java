package com.example.employeetodo.controller;

import com.example.employeetodo.model.Employee;
import com.example.employeetodo.model.Todo;
import com.example.employeetodo.repository.EmployeeRepository;
import com.example.employeetodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TodoRepository todoRepository;

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(updatedEmployee.getName());
            employee.setRole(updatedEmployee.getRole());
            return ResponseEntity.ok(employeeRepository.save(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employees/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable String role) {
        return employeeRepository.findByRole(role);
    }

    @PostMapping("/employee/{id}/todo")
    public ResponseEntity<Employee> addTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            todo.setEmployee(employee);
            todoRepository.save(todo);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
