package com.dkhagangroup.employeeSystem.service.impl;

import com.dkhagangroup.employeeSystem.dto.EducationDTO;
import com.dkhagangroup.employeeSystem.entity.Education;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.repository.EducationRepository;
import com.dkhagangroup.employeeSystem.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Kwaw
 */

@Service
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;

    /**
     * @param educationDTO
     *
     */
    @Override
    public void addEducation(EducationDTO educationDTO) {

    }

    /**
     * @param educationId : id of the education item to retrieve. Must not be null
     * @return : The entity with the educationId or Optional if non found returns null
     */
    @Override
    public Optional<Education> getEducationById(Long educationId) {
        return Optional.ofNullable(educationRepository.findById(educationId).orElse(null));
    }

    /**
     * @return : List of Education entities
     */
    @Override
    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    /**
     * @param educationId : must not be null
     * @return : Employee with the educationId specified or returns null
     */
    @Override
    public Employee getEmployeeByEducationId(Long educationId) {
        Optional<Education> educationOptional = educationRepository.findById(educationId);
        return educationOptional.map(Education::getEmployee).orElse(null);
    }
}
