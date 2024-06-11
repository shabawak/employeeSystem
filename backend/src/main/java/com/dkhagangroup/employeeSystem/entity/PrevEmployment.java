package com.dkhagangroup.employeeSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "prevemployment")
public class PrevEmployment {
    @Id
    private Long id;

    @Column(nullable = false)
    private String instiName;

    @Column(nullable = false)
    private String jobPosition;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String endDate;

    @Column(nullable = false)
    private String reasonForLeaving;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

}
