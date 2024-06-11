package com.dkhagangroup.employeeSystem.service.impl;

import com.dkhagangroup.employeeSystem.dto.EmployeeDto;
import com.dkhagangroup.employeeSystem.entity.BankDetail;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.repository.EmployeeRepository;
import com.dkhagangroup.employeeSystem.service.EmployeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee getEmployee(Integer empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        return employee.orElse(null);
    }

    @Override
    public Employee getEmployeeByNumber(String empNumber){
        Optional<Employee> thisEmployee = Optional.ofNullable(employeeRepository.findByEmploymentNumber(empNumber));
        return thisEmployee.orElse(null);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @Transactional()
    @Override
    public void addEmployeeWithBankDetails(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public BankDetail fetcthBankDetailByEmployeeId(Integer empId){
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            return employee.getBank();
        };
        return null;
    }
}
