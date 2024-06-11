package com.dkhagangroup.employeeSystem.service;

import com.dkhagangroup.employeeSystem.entity.Employee;

public interface BankService {
    public Employee fetchEmployeeByBankDetial(Long bankId);
}
