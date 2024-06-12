package com.dkhagangroup.employeeSystem.service;

import com.dkhagangroup.employeeSystem.dto.EducationDTO;
import com.dkhagangroup.employeeSystem.entity.Education;
import com.dkhagangroup.employeeSystem.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    public void addEducation(EducationDTO educationDTO);
    public Optional<Education> getEducationById(Long educationId);
    public List<Education> getAllEducations();
    public Employee getEmployeeByEducationId(Long educationId);

}
