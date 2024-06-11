package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByEmploymentNumber(String empNumber);

    //@Query("select e.")
    //public String joinInfo();
}
