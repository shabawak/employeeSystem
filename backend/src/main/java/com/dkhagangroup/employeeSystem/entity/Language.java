package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String aReads;

    @Column(nullable = false)
    private String aWites;

    @Column(nullable = false)
    private String aspeaks;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
}
