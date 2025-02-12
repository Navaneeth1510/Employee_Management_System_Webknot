package com.employee.management.controller;

import com.employee.management.entity.SkillSetEntity;
import com.employee.management.services.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillsets")
public class SkillSetController {

    @Autowired
    private SkillSetService skillSetService;

    // GET all skill sets
    @GetMapping("/all")
    public List<SkillSetEntity> getAllSkillSets() {
        return skillSetService.getAllSkillSets();
    }

    // POST add a new skill set
    @PostMapping("/add")
    public List<SkillSetEntity> addSkillSets(@RequestBody List<SkillSetEntity> skillSets) {
        return skillSetService.addSkillSets(skillSets);
    }
}

