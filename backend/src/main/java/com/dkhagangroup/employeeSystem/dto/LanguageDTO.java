package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {


    private Long id;


    private String language;


    private Boolean a_reads;


    private Boolean a_writes;


    private Boolean a_speaks;


    private Employee employee;

    @JsonBackReference
    public Employee getEmployee(){return employee;}
}
