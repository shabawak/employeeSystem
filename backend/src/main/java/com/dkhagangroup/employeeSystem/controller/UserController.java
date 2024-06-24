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
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;





    @GetMapping("/user/all-users")
    public ResponseEntity<Object> allUsers() {
        List<Users> allUsers = usersService.getAllLoginUsers();
        String message;

        if (allUsers.isEmpty()) {
            message = "No users available!";
        } else {
            message = "Available users!";
        }

        return ResponseHandler.responseBuilder(message, HttpStatus.OK, allUsers);
    }


    @PostMapping("/user/new-user")
    public ResponseEntity<Object> addNewUser(@RequestBody UsersDTO usersDTO) {
        String message;
        // Check if the provided username is empty or is not within accepted limit
        if (usersDTO.getUsername() == null || usersDTO.getUsername().isEmpty() ||
                usersDTO.getUsername().length() <= 4 || usersDTO.getUsername().length() >= 16) {
            message = "Username must be between five and fifteen characters long!";
            return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
        }
        // Check if the provided is null or empty
        if (usersDTO.getEmail() == null || usersDTO.getEmail().isEmpty()) {
            message = "Email cannot be empty!";
            return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
        }
        // Check if the provided password is null or empty
        if (usersDTO.getPassword() == null || usersDTO.getPassword().isEmpty()) {
            message = "Password cannot be empty!";
            return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
        }
        // Check if the provided username is already taken by another user
        Optional<Users> userNameOptional = Optional.ofNullable(usersService.findUserByUsername(usersDTO.getUsername()));
        if (userNameOptional.isPresent()) {
            message = "Username already exists! Please choose another one.";
            return ResponseHandler.responseBuilder(message, HttpStatus.CONFLICT, null);
        }
        // Check if the provided email is already taken by another user
        Optional<Users> userEmailOptional = Optional.ofNullable(usersService.findUserByEmail(usersDTO.getEmail()));
        if (userEmailOptional.isPresent()) {
            message = "Email already exists!";
            return ResponseHandler.responseBuilder(message, HttpStatus.CONFLICT, null);
        }
        // Construct a new user
        Users user = new Users(
                usersDTO.getId(),
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getUsername(),
                usersDTO.getEmail(),
                passwordEncoder.encode(usersDTO.getPassword())
        );

        message = "New user added!";

        try {
            //Adds the  new user to the Users entity
            usersService.addLoginUser(user);
            return ResponseHandler.responseBuilder(message, HttpStatus.CREATED, null);
        } catch (Exception e) {
            message = "Error occurred while adding a new user: " + e.getMessage();
            return ResponseHandler.responseBuilder(message, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @PutMapping("/user/update-user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Integer userId, @RequestBody UsersDTO usersDTO){
        String message;

        Optional<Users> userOptional = Optional.ofNullable(usersService.getLoginUserById(userId));
        if (userOptional.isPresent()) {
            Users existingUser = userOptional.get();

            if (usersDTO.getUsername().isEmpty() || usersDTO.getUsername().length() <= 4 || usersDTO.getUsername().length() >= 16){
                message = "Username must be between five and fifteen characters long!";
                return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
            }

            // Check if the provided username is already taken by another user
            Optional<Users> userNameOptional = Optional.ofNullable(usersService.findUserByUsername(usersDTO.getUsername()));
            if (userNameOptional.isPresent() && !userNameOptional.get().getId().equals(userId)){
                message = "Username already exists! Please choose another one.";
                return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
            }

            // Check if the provided email is already taken by another user
            Optional<Users> emailOptional = Optional.ofNullable(usersService.findUserByEmail(usersDTO.getEmail()));
            if (emailOptional.isPresent() && !emailOptional.get().getId().equals(userId)){
                message = "Email already exists!";
                return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
            }

            // Update user details
            existingUser.setFirstName(usersDTO.getFirstName());
            existingUser.setLastName(usersDTO.getLastName());
            existingUser.setUsername(usersDTO.getUsername());
            existingUser.setEmail(usersDTO.getEmail());

            // Save updated user
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
    }


    @DeleteMapping("/user/delete-user/{userID}")
    public ResponseEntity<Object> deleteExistingUser(@PathVariable("userID") Integer id) {
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
    }


    @PostMapping("/user/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginDTO loginDTO) {
        String message;
        Users user = usersService.findUserByUsername(loginDTO.getUsername());

        if (user != null) {
            String encodedPassword = user.getPassword();
            boolean isPasswordMatch = passwordEncoder.matches(loginDTO.getPassword(), encodedPassword);

            if (isPasswordMatch) {
                message = "Login success!";
                return ResponseHandler.responseBuilder(message, HttpStatus.OK, user.getUsername());
            } else {
                message = "Incorrect Password!";
                return ResponseHandler.responseBuilder(message, HttpStatus.UNAUTHORIZED, null);
            }
        } else {
            message = "User doesn't exist!";
            return ResponseHandler.responseBuilder(message, HttpStatus.NOT_FOUND, null);
        }
    }

    @PostMapping("/user/authenticate")
    public ResponseEntity<Object> userAuth(@RequestBody UsersDTO usersDTO){
        String message;
        Optional<Optional<Users>> userOptional = Optional.ofNullable(usersService.findOneByUsernameAndPassword(
                usersDTO.getUsername()
                , passwordEncoder.encode(usersDTO.getPassword())
        ));
        if (userOptional.isPresent()) {
            message = "success";
            return ResponseHandler.responseBuilder(message, HttpStatus.OK, null);
        }
        message ="fail";
        return ResponseHandler.responseBuilder(message, HttpStatus.BAD_REQUEST, null);
    }





}
