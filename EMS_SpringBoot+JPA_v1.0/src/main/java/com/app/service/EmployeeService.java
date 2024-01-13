package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.Employee;
import com.app.pojos.Project;

public interface EmployeeService {

	Employee authenticateLoginUserCreds(String email,String password);
	String addEmployeeDetails(Employee emp,String departmentName);
	List<Employee> getAllEmployeeDetails();
	Employee getEmployeeByEmail(String email);
	Set<Project> getEmployeeProjects(String email);

	
}
