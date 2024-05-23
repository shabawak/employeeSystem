package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findOneByUsernameAndPassword(String username, String password);
    Users findByUsername(String username);
    Users findByEmail(String username);

}

