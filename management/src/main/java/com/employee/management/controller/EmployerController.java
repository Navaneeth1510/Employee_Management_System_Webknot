package com.employee.management.controller;

import com.employee.management.entity.EmployerEntity;
import com.employee.management.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    // GET all employers
    @GetMapping("/all")
    public List<EmployerEntity> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    // POST add a new employer
    @PostMapping("/add")
    public List<EmployerEntity> addEmployers(@RequestBody List<EmployerEntity> employers) {
        return employerService.addEmployers(employers);
    }
}
