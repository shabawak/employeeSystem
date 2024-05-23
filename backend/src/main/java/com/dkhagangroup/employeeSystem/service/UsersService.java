package com.dkhagangroup.employeeSystem.service;

import com.dkhagangroup.employeeSystem.dto.LoginDTO;
import com.dkhagangroup.employeeSystem.dto.UsersDTO;
import com.dkhagangroup.employeeSystem.entity.Users;
import com.dkhagangroup.employeeSystem.response.ResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {

    public void addLoginUser(Users user);
    public List<Users> getAllLoginUsers();
    public void updateLoginUser(Users user);
    public void deleteLoginUser(Integer id);
    public Users getLoginUserById(Integer id);//helper method
    public Users findUserByUsername(String username);
    public Users findUserByEmail(String username);
    Optional<Users> findOneByUsernameAndPassword(String username, String password);




    //login

}
