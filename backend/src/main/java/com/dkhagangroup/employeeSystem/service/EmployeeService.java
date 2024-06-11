package com.dkhagangroup.employeeSystem.service;

import com.dkhagangroup.employeeSystem.dto.EmployeeDto;
import com.dkhagangroup.employeeSystem.entity.BankDetail;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    public void createEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Integer empId);
    public Employee getEmployee(Integer empId);
    public Employee getEmployeeByNumber(String empNumber);
    public List<Employee> getAllEmployee();
    public BankDetail fetcthBankDetailByEmployeeId(Integer empId);


    public void addEmployeeWithBankDetails(EmployeeDto employeeDto);
}
