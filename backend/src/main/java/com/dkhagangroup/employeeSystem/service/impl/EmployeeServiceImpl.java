package com.dkhagangroup.employeeSystem.service.impl;

import com.dkhagangroup.employeeSystem.dto.EmployeeDto;
import com.dkhagangroup.employeeSystem.entity.*;
import com.dkhagangroup.employeeSystem.repository.EmployeeRepository;
import com.dkhagangroup.employeeSystem.service.EmployeeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

    @PersistenceContext
    private EntityManager entityManager;

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
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
    }
    @Transactional
    public void addEmployeeW(EmployeeDto employeeDto){
        /* EMPLOYEE */
        Employee employee =  new Employee();
        employee.setId(employeeDto.getId());
        employee.setF_name(employeeDto.getF_name());
        employee.setL_name(employeeDto.getL_name());
        employee.setO_name(employeeDto.getO_name());
        employee.setGender(employeeDto.getGender());
        employee.setMaritalStatus(employeeDto.getMaritalStatus());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setGender(employeeDto.getGender());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setSnnitNumber(employeeDto.getSnnitNumber());
        employee.setGhCardNumber(employeeDto.getGhCardNumber());
        employee.setProfilePhoto(employeeDto.getProfilePhoto());
        employee.setReligion(employeeDto.getReligion());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setEmploymentType(employeeDto.getEmploymentType());
        employee.setEmploymentNumber(employeeDto.getEmploymentNumber());
        employee.setStartDate(employeeDto.getStartDate());
        employee.setSupervisor(employeeDto.getSupervisor());
       //employee.setBank(employeeDto.getBank());
        //employee.setEducation(employeeDto.getEducation());
        entityManager.persist(employee);

        /* Education */
        List<Education> educations = employeeDto.getEducation();
        //Education education = new Education();
        educations.forEach( education -> {
            education.setEmployee(employee);
            entityManager.persist(education);
        });

        /* Bank Details */
        BankDetail bankDetail  = new BankDetail();

        bankDetail.setAccount_name(employeeDto.getBank().getAccount_name());
        bankDetail.setBank_name(employeeDto.getBank().getBank_name());
        bankDetail.setBranch_name(employeeDto.getBank().getBranch_name());
        bankDetail.setAccount_type(employeeDto.getBank().getAccount_type());
        bankDetail.setAccount_number(employeeDto.getBank().getAccount_number());
        bankDetail.setEmployee(employee);
        entityManager.persist(bankDetail);

        /* Address */
        Address address = new Address();
        address.setCountry(employeeDto.getAddress().getCountry());
        address.setRegion(employeeDto.getAddress().getRegion());
        address.setCurrAddress(employeeDto.getAddress().getCurrAddress());
        address.setDigiAddress(employeeDto.getAddress().getDigiAddress());
        address.setStreetName(employeeDto.getAddress().getStreetName());
        address.setCommunityName(employeeDto.getAddress().getCommunityName());
        address.setDistName(employeeDto.getAddress().getDistName());
        address.setPostArea(employeeDto.getAddress().getPostArea());
        address.setPostCode(employeeDto.getAddress().getPostCode());
        address.setLandmark(employeeDto.getAddress().getLandmark());
        address.setEmployee(employee);
        entityManager.persist(address);

        /* Language */
        List<Languages> languages = employeeDto.getLanguages();
        languages.forEach( language -> {
            language.setEmployee(employee);
            entityManager.persist(language);
        });


    }

    @Transactional(readOnly = true)
    @Override
    public BankDetail fetchBankDetailByEmployeeId(Integer empId){
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            return employee.getBank();
        };
        return null;
    }
}
