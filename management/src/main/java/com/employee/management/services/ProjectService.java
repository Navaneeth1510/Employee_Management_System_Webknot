package com.employee.management.services;

import com.employee.management.entity.ProjectEntity;
import com.employee.management.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepository;

//    @Cacheable(value = "projects")
    public List<ProjectEntity> getAllProjects() {
        System.out.println("Fetching from Database...");
        return projectRepository.findAll();
    }

    // Add multiple projects and update cache
//    @CacheEvict(value = "projects", allEntries = true)
    public List<ProjectEntity> addProjects(List<ProjectEntity> projects) {
        return projectRepository.saveAll(projects);
    }
}

