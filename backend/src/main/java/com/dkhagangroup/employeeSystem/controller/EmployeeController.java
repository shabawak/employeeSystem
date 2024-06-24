package com.dkhagangroup.employeeSystem.controller;

import com.dkhagangroup.employeeSystem.dto.EmployeeDto;
import com.dkhagangroup.employeeSystem.dto.LoginDTO;
import com.dkhagangroup.employeeSystem.dto.UsersDTO;
import com.dkhagangroup.employeeSystem.entity.BankDetail;
import com.dkhagangroup.employeeSystem.entity.Education;
import com.dkhagangroup.employeeSystem.entity.Employee;
import com.dkhagangroup.employeeSystem.entity.Users;
import com.dkhagangroup.employeeSystem.response.ResponseHandler;
import com.dkhagangroup.employeeSystem.service.BankService;
import com.dkhagangroup.employeeSystem.service.EducationService;
import com.dkhagangroup.employeeSystem.service.EmployeeService;
import com.dkhagangroup.employeeSystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee-system/api/v1")
@AllArgsConstructor
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employee/all")
    public ResponseEntity<Object> allEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        String message;
        if (allEmployee.isEmpty()) {
            message = "No employees available!";
        } else {
            message = "Available employees!";
        }

        return ResponseHandler.responseBuilder(message, HttpStatus.OK, allEmployee);
    }


    @PostMapping("/employee/new-employee")
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employeeDto) {
        String message;

        // Check if the employee is already in the system
        Optional<Employee> employee = Optional.ofNullable(employeeService.getEmployeeByNumber(employeeDto.getEmploymentNumber()));
        if (employee.isPresent()) {
            message = "Employee already exists!";
            return ResponseHandler.responseBuilder(message, HttpStatus.CONFLICT, null);
        }
        // Add a new employee
        else {

            message = "New user added!";

            try {
                //Adds the  new user to the Users entity
                employeeService.addEmployeeW(employeeDto);

                return ResponseHandler.responseBuilder(message, HttpStatus.CREATED, null);
            } catch (Exception e) {
                message = "Error occurred while adding a new user: " + e.getMessage();
                return ResponseHandler.responseBuilder(message, HttpStatus.INTERNAL_SERVER_ERROR, null);
            }

        }
    }


    //@PutMapping("/employee/edit/{id}")
    /*public ResponseEntity<Object> editEmployee(@PathVariable("id") Integer empId,@Valid @RequestBody EmployeeDto employeeDto){
        String message;

        Optional<Employee> thisEmployee = Optional.ofNullable(employeeService.getEmployee(empId));
        if (thisEmployee.isPresent()) {
            Employee employee = thisEmployee.get();

            // Update employee details
            employee.setFName(employeeDto.getFName());
            employee.setLName(employeeDto.getLName());

            // Save updated employee details
            try {
                usersService.updateLoginUser(existingUser);
                message = "User updated successfully!";
                return ResponseHandler.responseBuilder(message, HttpStatus.OK, null);
            } catch (Exception e) {
                message = "Error occurred while updating user: " + e.getMessage();
                return ResponseHandler.responseBuilder(message, HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
        } else {
            message = "User not found!";
            return ResponseHandler.responseBuilder(message, HttpStatus.NOT_FOUND, null);
        }
    }*/


    //@DeleteMapping("/user/delete-user/{userID}")
    /*public ResponseEntity<Object> deleteExistingUser(@PathVariable("userID") Integer id) {
        String message;
        Users userToDelete = usersService.getLoginUserById(id);

        if (userToDelete == null) {
            message = "User does not exist!";
            return ResponseHandler.responseBuilder(message, HttpStatus.NOT_FOUND, null);
        } else {
            try {
                usersService.deleteLoginUser(id);
                message = "User deleted successfully!";
                return ResponseHandler.responseBuilder(message, HttpStatus.OK, null);
            } catch (Exception e) {
                message = "Error deleting user: " + e.getMessage();
                return ResponseHandler.responseBuilder(message, HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
        }
    }*/


    // Exception handling
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Validation Error: " + ex.getBindingResult().getFieldError().getDefaultMessage());
    }*/



}
