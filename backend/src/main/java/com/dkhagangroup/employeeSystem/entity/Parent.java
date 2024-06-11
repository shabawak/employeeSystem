package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)

    private String f_name;
    @Column(nullable = false)

    private int f_age;
    @Column(nullable = false)
    private String f_occupation;

    @Column(nullable = false)
    private String f_remarks;

    @Column(nullable = false)
    private String m_name;

    @Column(nullable = false)
    private int m_age;

    @Column(nullable = false)
    private String m_occupation;

    @Column(nullable = false)
    private String m_remarks;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

}
