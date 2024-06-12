package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.*;
import com.dkhagangroup.employeeSystem.enums.EmploymentType;
import com.dkhagangroup.employeeSystem.enums.Gender;
import com.dkhagangroup.employeeSystem.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    //personal details

    private String f_name;

    private String l_name;

    private String o_name;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String birthDate;

    private String religion;

    private String email;


    private int phone;


    private String snnitNumber;


    private String ghCardNumber;


    private String profilePhoto;

    //employment details

    private String jobTitle;


    private String department;


    private EmploymentType employmentType;


    private String employmentNumber;


    private String startDate;


    private String supervisor;
    //Bank detail

    private BankDetail bank;

    private List<Education> education = new ArrayList<>();


}
