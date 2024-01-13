package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DepartmentDao;
import com.app.dao.EmployeeDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private DepartmentDao deptDao;

	public EmployeeServiceImpl() {
		System.out.println("Employee Service Dependency Injected");
	}

	@Override
	public Employee authenticateLoginUserCreds(String email, String password) {
		Employee emp = null;
		try {
			emp = empDao.findByEmailAndPassword(email, password).orElseThrow();			
		} catch (Exception e) {
			System.out.println("Authentication Failed of User!");
		}
		return emp;
	}

	@Override
	public String addEmployeeDetails(Employee emp,String departmentName) {
		Department deptObj = deptDao.findByName(departmentName).orElseThrow();
		deptObj.addEmployee(emp);
		empDao.save(emp);
		return "added!";
	}
	
	public List<Employee> getAllEmployeeDetails()
	{
		return empDao.findAll();
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return empDao.findByEmail(email).orElseThrow();
	}
	
	
}
