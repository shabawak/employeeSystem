package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Languages, Long> {
}
