package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Department;

public interface DepartmentDao extends JpaRepository<Department, Long>{

	Optional<Department> findByName(String departmentName);
	
}
