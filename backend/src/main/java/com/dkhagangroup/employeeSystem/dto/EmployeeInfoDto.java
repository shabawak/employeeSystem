package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.enums.EmploymentType;
import com.dkhagangroup.employeeSystem.enums.Gender;
import com.dkhagangroup.employeeSystem.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeInfoDto {
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
}
