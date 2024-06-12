package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.Employee;
import jakarta.persistence.*;

public class EducationDTO {

    private Long id;


    private String institution;


    private String major;


    private String graduation_date;


    private String certificate_type;


    private Employee employee;
}
