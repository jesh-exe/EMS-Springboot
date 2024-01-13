package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity{

	@Column(name = "start_date",nullable = false)
	private LocalDate startDate;
	@Column(name = "end_date",nullable = false)
	private LocalDate endDate;
	@Column(name = "title",nullable = false ,unique = true)
	private String title;

	@ManyToMany(mappedBy = "employeeProjects",fetch = FetchType.EAGER)
	Set<Employee> employeesOnProject = new HashSet<Employee>();

	public Project() {}
	
	public Project(String startDate, String endDate, String title) {
		super();
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		this.title = title;
	}

	public boolean addEmployee(Employee emp)
	{
		return employeesOnProject.add(emp);
	}
	
	public boolean removeEmployee(Employee emp)
	{
		return employeesOnProject.remove(emp);
	}
	
	public void removeAllEmployeesOnProject()
	{
		for(Employee emp : employeesOnProject)
		{
			emp.removeProject(this);
		}
		employeesOnProject.clear();
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployeesOnProject() {
		return employeesOnProject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [startDate=" + startDate + ", endDate=" + endDate + ", title=" + title + "]";
	}
	
	
	
}
