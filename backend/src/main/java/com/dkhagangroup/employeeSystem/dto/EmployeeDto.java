package com.dkhagangroup.employeeSystem.dto;

import com.dkhagangroup.employeeSystem.entity.*;
import com.dkhagangroup.employeeSystem.enums.EmploymentType;
import com.dkhagangroup.employeeSystem.enums.Gender;
import com.dkhagangroup.employeeSystem.enums.MaritalStatus;



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

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String f_name, String l_name, String o_name
            , Gender gender, MaritalStatus maritalStatus, String birthDate
            , String religion, String email, int phone, String snnitNumber
            , String ghCardNumber, String profilePhoto, String jobTitle
            , String department, EmploymentType employmentType
            , String employmentNumber, String startDate, String supervisor, BankDetail bank) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.o_name = o_name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.birthDate = birthDate;
        this.religion = religion;
        this.email = email;
        this.phone = phone;
        this.snnitNumber = snnitNumber;
        this.ghCardNumber = ghCardNumber;
        this.profilePhoto = profilePhoto;
        this.jobTitle = jobTitle;
        this.department = department;
        this.employmentType = employmentType;
        this.employmentNumber = employmentNumber;
        this.startDate = startDate;
        this.supervisor = supervisor;
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSnnitNumber() {
        return snnitNumber;
    }

    public void setSnnitNumber(String snnitNumber) {
        this.snnitNumber = snnitNumber;
    }

    public String getGhCardNumber() {
        return ghCardNumber;
    }

    public void setGhCardNumber(String ghCardNumber) {
        this.ghCardNumber = ghCardNumber;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public String getEmploymentNumber() {
        return employmentNumber;
    }

    public void setEmploymentNumber(String employmentNumber) {
        this.employmentNumber = employmentNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public BankDetail getBank() {
        return bank;
    }

    public void setBank(BankDetail bank) {
        this.bank = bank;
    }
}
