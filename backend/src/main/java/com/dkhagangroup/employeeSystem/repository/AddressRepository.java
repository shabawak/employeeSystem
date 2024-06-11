package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
