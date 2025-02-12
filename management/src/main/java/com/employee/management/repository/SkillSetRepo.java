package com.employee.management.repository;

import com.employee.management.entity.SkillSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSetRepo extends JpaRepository<SkillSetEntity, Long> {
}
