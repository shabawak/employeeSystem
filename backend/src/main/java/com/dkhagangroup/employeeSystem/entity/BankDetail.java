package com.dkhagangroup.employeeSystem.entity;

import com.dkhagangroup.employeeSystem.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "bank")
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String account_name;

    @Column(nullable = false)
    private String bank_name;

    @Column(nullable = false)
    private String branch_name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private AccountType account_type;

    @Column(nullable = false)
    private int account_number;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bank", fetch = FetchType.LAZY)
    private Employee employee;


    public BankDetail() {
    }

    public BankDetail(Long id, String account_name, String bank_name
            , String branch_name, AccountType account_type
            , int account_number, Employee employee) {
        this.id = id;
        this.account_name = account_name;
        this.bank_name = bank_name;
        this.branch_name = branch_name;
        this.account_type = account_type;
        this.account_number = account_number;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    @JsonManagedReference
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
