package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reference")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ref_name;

    @Column(nullable = false)
    private String relationship;

    @Column(nullable = false)
    private String ref_inst_name;

    @Column(nullable = false)
    private String ref_position;

    @Column(nullable = false)
    private String ref_email;

    @Column(nullable = false)
    private int ref_phone;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

}
