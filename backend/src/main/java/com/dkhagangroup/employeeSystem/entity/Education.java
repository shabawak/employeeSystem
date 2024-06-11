package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String institution;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String graduation_date;

    @Column(nullable = false)
    private String certificate_type;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
}
