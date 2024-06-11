package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String account_name;
    @Column(nullable = false)
    private String bank_name;
    @Column(nullable = false)
    private String branch_name;
    @Column(nullable = false)
    private String account_type;
    @Column(nullable = false)
    private int account_number;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "")
    @Column(nullable = false)
    private Bank bank;

}
