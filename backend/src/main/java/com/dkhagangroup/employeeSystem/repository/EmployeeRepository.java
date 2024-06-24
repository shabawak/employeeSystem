package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.dto.EmployeeInfoDto;
import com.dkhagangroup.employeeSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findByEmploymentNumber(String empNumber);

    @Query("select new com.dkhagangroup.employeeSystem.dto.EmployeeInfoDto(e.id, e.f_name, e.l_name, e.o_name, e.gender, e.maritalStatus, e.birthDate, e.religion, e.email, e.phone, e.snnitNumber, e.ghCardNumber, e.profilePhoto, e.jobTitle, e.department, e.employmentType, e.employmentNumber, e.startDate, e.supervisor) from Employee e")
    public List<EmployeeInfoDto> allEmployee();


}
