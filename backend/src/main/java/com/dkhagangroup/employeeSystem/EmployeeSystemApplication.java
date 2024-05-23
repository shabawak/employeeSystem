package com.dkhagangroup.employeeSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.dkhagangroup.employeeSystem",exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = "com.dkhagangroup.employeeSystem.entity")
@EnableJpaRepositories(basePackages = "com.dkhagangroup.employeeSystem.repository")
public class EmployeeSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApplication.class, args);
		System.out.println("Springboot up!");
	}

}
