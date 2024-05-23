package com.dkhagangroup.employeeSystem.service;

import com.dkhagangroup.employeeSystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public String createEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(Integer empId);
    public Employee getEmployee(Integer empId);
    public List<Employee> getAllEmployee();
}
