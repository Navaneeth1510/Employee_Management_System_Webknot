package com.employee.management.services;

import com.employee.management.entity.SkillSetEntity;
import com.employee.management.repository.SkillSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillSetService {

    @Autowired
    private SkillSetRepo skillSetRepository;

    // Fetch all skill sets with Redis caching
    @Cacheable(value = "skillSets")
    public List<SkillSetEntity> getAllSkillSets() {
        System.out.println("Fetching skill sets from Database...");
        return skillSetRepository.findAll();
    }

    // Add multiple skill sets and clear cache to update with new data
    @CacheEvict(value = "skillSets", allEntries = true)
    public List<SkillSetEntity> addSkillSets(List<SkillSetEntity> skillSets) {
        return skillSetRepository.saveAll(skillSets);
    }
}
