package com.employee.management.services;

import com.employee.management.entity.EmployeeEntity;
import com.employee.management.entity.ProjectEntity;
import com.employee.management.entity.SkillSetEntity;
import com.employee.management.exception.ResourceNotFoundException;
import com.employee.management.repository.EmployeeRepo;
import com.employee.management.repository.ProjectRepo;
import com.employee.management.repository.SkillSetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepository;
    private final SkillSetRepo skillSetRepository;
    private final ProjectRepo projectRepository;

    // Fetch all employees with caching
//    @Cacheable(value = "employees")
    public List<EmployeeEntity> getAllEmployees() {
        System.out.println("Fetching employees from Database...");
        return employeeRepository.findAll();
    }

//    @Cacheable(value = "employees", key = "#id")
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

//    @CacheEvict(value = "employees", allEntries = true)
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

//    @CacheEvict(value = "employees", allEntries = true)
    public List<EmployeeEntity> addEmployees(List<EmployeeEntity> employees) {
        return employeeRepository.saveAll(employees);
    }

//    @CacheEvict(value = "employees", key = "#id")
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity updatedEmployee) {
        EmployeeEntity employee = getEmployeeById(id);
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setRole(updatedEmployee.getRole());
        employee.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(employee);
    }

//    @CacheEvict(value = "employees", key = "#id")
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return true;
    }

//    @CacheEvict(value = "employees", key = "#empId")
    public EmployeeEntity addSkill(Long empId, Long skillId) {
        EmployeeEntity employee = getEmployeeById(empId);
        SkillSetEntity skill = skillSetRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        employee.getSkillSets().add(skill);
        return employeeRepository.save(employee);
    }

//    @CacheEvict(value = "employees", key = "#empId")
    public EmployeeEntity removeSkill(Long empId, Long skillId) {
        EmployeeEntity employee = getEmployeeById(empId);
        SkillSetEntity skill = skillSetRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
        employee.getSkillSets().remove(skill);
        return employeeRepository.save(employee);
    }

//    @CacheEvict(value = "employees", key = "#empId")
    public EmployeeEntity assignProject(Long empId, Long projectId) {
        EmployeeEntity employee = getEmployeeById(empId);
        ProjectEntity project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        employee.getProjects().add(project);
        return employeeRepository.save(employee);
    }
}
