package com.dkhagangroup.employeeSystem.entity;

import com.dkhagangroup.employeeSystem.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_Id", referencedColumnName = "id",nullable = false)
    private Employee employee;




    @JsonBackReference
    public Employee getEmployee() {
        return employee;
    }

}
