package com.dkhagangroup.employeeSystem.service.impl;

import com.dkhagangroup.employeeSystem.entity.BankDetail;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.repository.BankDetailRepository;
import com.dkhagangroup.employeeSystem.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankDetailRepository bankDetailRepository;

    @Transactional(readOnly = true)
    @Override
    public Employee fetchEmployeeByBankDetial(Long bankId) {
        Optional<BankDetail> thisBankDetail = bankDetailRepository.findById(bankId);
        if (thisBankDetail.isPresent()){
            BankDetail bankDetail = thisBankDetail.get();
            return bankDetail.getEmployee();
        }
        return null;
    }
}
