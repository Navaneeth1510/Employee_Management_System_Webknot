package com.employee.management.controller;

import com.employee.management.entity.EmployeeEntity;
import com.employee.management.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //all the get methods
    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    //all the add methods
    @PostMapping
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/add")
    public List<EmployeeEntity> addEmployees(@RequestBody List<EmployeeEntity> employees) {
        return employeeService.addEmployees(employees);
    }

    //all the delete methods
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }


    //all the edit methods
    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @PostMapping("/{empId}/skills/{skillId}")
    public EmployeeEntity addSkill(@PathVariable Long empId, @PathVariable Long skillId) {
        return employeeService.addSkill(empId, skillId);
    }

    @DeleteMapping("/{empId}/skills/{skillId}")
    public EmployeeEntity removeSkill(@PathVariable Long empId, @PathVariable Long skillId) {
        return employeeService.removeSkill(empId, skillId);
    }

    @PostMapping("/{empId}/projects/{projectId}")
    public EmployeeEntity assignProject(@PathVariable Long empId, @PathVariable Long projectId) {
        return employeeService.assignProject(empId, projectId);
    }
}

