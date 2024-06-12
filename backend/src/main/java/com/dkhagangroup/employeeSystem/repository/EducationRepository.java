package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
