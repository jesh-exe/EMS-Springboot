package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>{

	Optional<Employee> findByEmailAndPassword(String email,String password);
	Optional<Employee> findByEmail(String email);
	
}
