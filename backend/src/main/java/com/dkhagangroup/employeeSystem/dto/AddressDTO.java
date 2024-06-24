package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;


    private String Country;


    private String region;


    private String currAddress;


    private String digiAddress;


    private String streetName;


    private String communityName;


    private String distName;


    private String postArea;


    private String postCode;


    private String landmark;

    private Employee employee;
}
