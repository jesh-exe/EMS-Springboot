package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {

	Employee authenticateLoginUserCreds(String email,String password);
	String addEmployeeDetails(Employee emp,String departmentName);
	List<Employee> getAllEmployeeDetails();
	Employee getEmployeeByEmail(String email);
	
}
