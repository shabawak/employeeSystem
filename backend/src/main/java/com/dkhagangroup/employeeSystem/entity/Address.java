package com.dkhagangroup.employeeSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Country;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String currAddress;

    @Column(nullable = false)
    private String digiAddress;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String communityName;

    @Column(nullable = false)
    private String distName;

    @Column(nullable = false)
    private String postArea;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private String landmark;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    private Employee employee;



    @JsonBackReference
    public Employee getEmployee(){return employee;}





}
