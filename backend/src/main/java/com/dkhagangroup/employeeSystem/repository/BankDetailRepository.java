package com.dkhagangroup.employeeSystem.repository;

import com.dkhagangroup.employeeSystem.entity.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailRepository extends JpaRepository<BankDetail, Long> {
}
