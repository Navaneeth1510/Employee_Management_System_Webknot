package com.employee.management.repository;

import com.employee.management.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<EmployerEntity, Long> {
}
