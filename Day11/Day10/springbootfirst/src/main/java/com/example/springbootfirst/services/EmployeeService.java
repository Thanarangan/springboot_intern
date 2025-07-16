package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public String addEmployee(UserDetailsDto employee) {
        RegisterDetails newEmployee = new RegisterDetails();
        newEmployee.setName(employee.getName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setUserName(employee.getUserName());
        newEmployee.setAddress(employee.getAddress());
        newEmployee.setDob(employee.getDob());
        newEmployee.setFatherName(employee.getFatherName());

        Set<Roles> roles = new HashSet<>();
        for (String roleName : employee.getRoles()) {
            Roles role = rolesRepository.findByRoleName(roleName.toUpperCase())
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        newEmployee.setRoles(roles);

        registerDetailsRepository.save(newEmployee);
        return "Employee added successfully";
    }

    public RegisterDetails getEmployeeById(int id) {
        return registerDetailsRepository.findById(id).orElse(new RegisterDetails());
    }

    public String updateEmployee(int id, UserDetailsDto employee) {
        Optional<RegisterDetails> existingEmployeeOpt = registerDetailsRepository.findById(id);

        if (existingEmployeeOpt.isPresent()) {
            RegisterDetails existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPassword(employee.getPassword());
            existingEmployee.setUserName(employee.getUserName());

            Set<Roles> roles = new HashSet<>();
            for (String roleName : employee.getRoles()) {
                Roles role = rolesRepository.findByRoleName(roleName.toUpperCase())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
                roles.add(role);
            }
            existingEmployee.setRoles(roles);

            registerDetailsRepository.save(existingEmployee);
            return "Employee updated successfully";
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public String deleteMethod(int id) {
        registerDetailsRepository.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<RegisterDetails> getbyroles(String role) {
        List<RegisterDetails> employees = new ArrayList<>();

        for (RegisterDetails registerDetails : registerDetailsRepository.findAll()) {
            for (Roles roles : registerDetails.getRoles()) {
                if (roles.getRoleName().equalsIgnoreCase(role)) {
                    employees.add(registerDetails);
                }
            }
        }
        return employees;
    }

    // public List<RegisterDetails> getEmployeeByJob(String job) {
    //     return registerDetailsRepository.getEmployeeByJob(job);
    // }
}
