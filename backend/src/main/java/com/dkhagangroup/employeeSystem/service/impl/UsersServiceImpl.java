package com.dkhagangroup.employeeSystem.service.impl;

import com.dkhagangroup.employeeSystem.entity.Users;
import com.dkhagangroup.employeeSystem.repository.UsersRepository;
import com.dkhagangroup.employeeSystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    @Override
    public void addLoginUser(Users user) {
        usersRepository.save(user);

    }

    @Override
    public List<Users> getAllLoginUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void updateLoginUser(Users user) {
        usersRepository.save(user);

    }

    @Override
    public void deleteLoginUser(Integer id) {
       usersRepository.deleteById(id);

    }

    @Override
    public Users getLoginUserById(Integer id) { //helper method
        Optional<Users> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Users findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> findOneByUsernameAndPassword(String username, String password) {
        return usersRepository.findOneByUsernameAndPassword(username, password);
    }




}
