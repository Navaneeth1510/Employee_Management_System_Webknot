package com.employee.management.controller;

import com.employee.management.entity.ProjectEntity;
import com.employee.management.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GET all projects
    @GetMapping("/all")
    public List<ProjectEntity> getAllProjects() {
        return projectService.getAllProjects();
    }

    // POST add a new project
    @PostMapping("/add")
    public List<ProjectEntity> addProjects(@RequestBody List<ProjectEntity> projects) {
        return projectService.addProjects(projects);
    }
}

