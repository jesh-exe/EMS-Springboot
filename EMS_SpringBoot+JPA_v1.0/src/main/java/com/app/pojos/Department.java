package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{
	
	@Column(length = 30, unique = true)
	private String name;
	@Column(length = 60)
	private String location;
	
	/*
	 * Cascade All is used to reflect the change in Database after we insert anything in the SET
	 * we dont need to explicitly call the persist method to save the Employee data
	 * 
	 * Orphan Removal is used whenever we call remove method of Session, it will not delete the employees
	 * related to the Department rather it will nullify the FK of Employee table maling them orphan
	 * Hence we enable orphan removal to ensure that if the Department is deleted,then the employess associated with the Department
	 * are also removed from the DATABASE
	 */
	
	@OneToMany(mappedBy = "myDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Employee> employees = new HashSet<Employee>();
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public boolean addEmployee(Employee obj) {
		if(!employees.add(obj))
			return false;
		obj.setMyDepartment(this);
		return true;
	}
	
	public void removeEmployee(Employee obj)
	{
		employees.remove(obj);
		obj.setMyDepartment(null);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	
	
}
