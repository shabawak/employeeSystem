package com.dkhagangroup.employeeSystem.controller;

import com.dkhagangroup.employeeSystem.entity.Education;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.response.ResponseHandler;
import com.dkhagangroup.employeeSystem.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee-system/api/v1")
@AllArgsConstructor
public class EducationController {


    @Autowired
    private EducationService educationService;




    /**
     *
     * @return : Education Objects
     *
     */
    @GetMapping("/employee/education/all")
    public ResponseEntity<Object> getAllEducation(){
        String message;
        List<Education> employeeList = educationService.getAllEducations();
        if(!employeeList.isEmpty()){
            message =   "Available Education List";
            return ResponseHandler.responseBuilder(message, HttpStatus.OK, employeeList);
        }
        message = "No education data available";
        return ResponseHandler.responseBuilder(message,HttpStatus.OK, employeeList);
    }

    /**
     * @param: educationId
     * @return: Employee
     */
    @GetMapping("/employee/education/employee-education/{educationId}")
    public ResponseEntity<Object> fetchEmployeeByEducationId(@PathVariable("educationId")Long educationId){
        String message;
        Optional<Education> educationOptional = educationService.getEducationById(educationId);
        if (educationOptional.isPresent()){
            Employee employee = educationOptional.get().getEmployee();
            message = "Employee found";
            return  ResponseHandler.responseBuilder(message, HttpStatus.OK, employee);
        }
        message = "Employee not found";
        return ResponseHandler.responseBuilder(message, HttpStatus.NOT_FOUND, null);
    }
}
