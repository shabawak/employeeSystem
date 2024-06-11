package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailDTO {

    private Long id;


    private String account_name;


    private String bank_name;


    private String branch_name;


    private AccountType account_type;


    private int account_number;

    //Employee

    private Employee employee;
}
