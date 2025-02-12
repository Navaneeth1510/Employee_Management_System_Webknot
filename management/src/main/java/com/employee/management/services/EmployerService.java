package com.employee.management.services;

import com.employee.management.entity.EmployerEntity;
import com.employee.management.repository.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepo employerRepository;

    // Fetch all employers with Redis caching
//    @Cacheable(value = "employers")
    public List<EmployerEntity> getAllEmployers() {
        System.out.println("Fetching employers from Database...");
        return employerRepository.findAll();
    }

    // Add multiple employers and clear cache to update with new data
//    @CacheEvict(value = "employers", allEntries = true)
    public List<EmployerEntity> addEmployers(List<EmployerEntity> employers) {
        return employerRepository.saveAll(employers);
    }
}
