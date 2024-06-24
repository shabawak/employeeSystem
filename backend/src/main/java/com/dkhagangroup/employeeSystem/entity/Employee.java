package com.dkhagangroup.employeeSystem.entity;

import com.dkhagangroup.employeeSystem.enums.EmploymentType;
import com.dkhagangroup.employeeSystem.enums.Gender;
import com.dkhagangroup.employeeSystem.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //personal details
    @Column(name ="f_name" , nullable = false)
    private String f_name;

    @Column(name = "l_name", nullable = false)
    private String l_name;

    @Column(name = "o_name")
    private String o_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status",nullable = false)
    private MaritalStatus maritalStatus;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "religion", nullable = false)
    private String religion;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "snnit_number", nullable = false)
    private String snnitNumber;

    @Column(name = "card_number", nullable = false)
    private String ghCardNumber;

    @Column(name = "profile_photo", nullable = true, length = 10000000)
    private String profilePhoto;

    //employment details
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "department", nullable = false)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type", nullable = false)
    private EmploymentType employmentType;

    @Column(name = "employment_number", nullable = false)
    private String employmentNumber;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "supervisor", nullable = false)
    private String supervisor;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private BankDetail bank;




    //RELATIONSHIPS
    //BANK
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    //private BankDetail bankDetail;
    //REFERENCE
    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.LAZY)
    //private Reference reference;
    //PARENT
    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee", fetch = FetchType.LAZY)
    //private Parent parent;

    //PREV-EMPLOYMENT
    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee", fetch = FetchType.LAZY)
    //private PrevEmployment prevEmployment;

    //ADDRESS
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee", fetch = FetchType.LAZY)
    private Address address;


    //LANGUAGE
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Languages> language;

    //EDUCATION
    @OneToMany( mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Education> education = new ArrayList<>();


    @JsonManagedReference
    public BankDetail getBank() {return bank;}

    @JsonManagedReference
    public List<Education> getEducation(){return education;}

    @JsonManagedReference
    public List<Languages> getLanguage(){return language;}

    @JsonManagedReference
    public Address getAddress(){return address;}

}
