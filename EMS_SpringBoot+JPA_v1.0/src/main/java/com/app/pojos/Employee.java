package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "emps")
public class Employee extends BaseEntity{

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(nullable = false)
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EmployementType type;
	@Column(nullable = false)
	private double salary;
	@Column(name="is_manager")
	private boolean manager;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department myDepartment;
	
	/*
	 * When we use Many To Many relationship there will be creation of another table with PK of both the table
	 * (Employee <-> Projects) we create Collection of each other on both side,
	 * we add JoinTable tag at the owning side to customize the table and tell the hibernate that which is owning and inverse side,
	 * or else Hibernate will create 2 tables emps_projects and projects_emps.
	 * To avoid such conflict we tell the hibernate that Employee is the owning side by Declaring the annotation @JoinTable
	 * with name of table,
	 * joinColumns tells the column name to be inserted
	 * inverseJoinColumns to tell the column name of PK of Project table
	 * 
	 * We add MappedBy attribute on the Collection of Employees
	 * 
	 */
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
			name = "emp_projects",
			joinColumns = {@JoinColumn(name = "emp_id")},
			inverseJoinColumns = {@JoinColumn(name = "project_id")}
			)
	private Set<Project> employeeProjects = new HashSet<Project>();
	
	/*
	 * To use strong aggregation we make a class Of property we want to contain in Employee and make sure that 
	 * Employee will have One to One relationship only, or else other table need to be maintained
	 * First step is to create a another class (Aadhaar) which will not have @Entity, @Table or @Id tag in it
	 * We need to give @Embedabble inplace of @Entity to tell hibernate that it will be a containment in the 
	 * Employee class
	 * So we declare the Reference variable of aadhar and to tell hibernate that declare variable is a part of
	 * aggregation we write @Embedded above the variable and Hibernate will add all the columns declared in the
	 * Aadhaar class in the Employee without creating other table.  
	 *
	 */
	@Embedded
	private Aadhaar aadhaarDetails;
	
	@ElementCollection
	@CollectionTable(name = "emp_skills", joinColumns = @JoinColumn(name = "emp_id"))
	private List<String> skills = new ArrayList<String>();
	
	
	@ElementCollection
	@CollectionTable(name = "emp_card_details", joinColumns = @JoinColumn(name="emp_id"))
	private List<PaymentCard> paymentCards = new ArrayList<PaymentCard>();
	
	public Employee(){}

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = EmployementType.valueOf(type.toUpperCase());
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String type, double salary, Aadhaar aadhaarDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = EmployementType.valueOf(type.toUpperCase());
		this.salary = salary;
		this.aadhaarDetails = aadhaarDetails;
	}
	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String type, double salary, Aadhaar aadhaarDetails,boolean manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = EmployementType.valueOf(type.toUpperCase());
		this.salary = salary;
		this.aadhaarDetails = aadhaarDetails;
		this.manager = manager;
	}
	
	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String type, double salary, String aadhaarNumber,String creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = EmployementType.valueOf(type.toUpperCase());
		this.salary = salary;
		this.aadhaarDetails = new Aadhaar(aadhaarNumber, creationDate);
	}
	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String type, double salary, String aadhaarNumber,String creationDate,boolean manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.type = EmployementType.valueOf(type.toUpperCase());
		this.salary = salary;
		this.aadhaarDetails = new Aadhaar(aadhaarNumber, creationDate);
		this.manager = true;
	}
	
	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public List<PaymentCard> getPaymentCards() {
		return paymentCards;
	}

	public void setPaymentCards(List<PaymentCard> paymentCards) {
		this.paymentCards = paymentCards;
	}

	/*
	 * We declare a method to add and remove a project object from the Set of Projects
	 * It will be called from the DAO Layer
	 */
	public void addSkills(List<String> skills)
	{
		this.skills.addAll(skills);
	}
	public void addSkills(String skill)
	{
		this.skills.add(skill);
	}
	public void remove(String skill)
	{
		this.skills.remove(skill);
	}
	
	public boolean addProject(Project proj)
	{
		return employeeProjects.add(proj);
	}
	
	public boolean removeProject(Project proj)
	{
		return employeeProjects.remove(proj);
	}
	
	public void removeAllProjects()
	{
		for(Project project : employeeProjects)
		{
			project.removeEmployee(this);
		}
		employeeProjects.clear();
	}

	@Override
	public String toString() {
		System.out.println();
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", joinDate=" + joinDate + ", type=" + type
				+ ", salary=" + salary +"Department"+myDepartment.getName()+ "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmployementType getType() {
		return type;
	}

	public void setType(EmployementType type) {
		this.type = type;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getMyDepartment() {
		return myDepartment;
	}

	public void setMyDepartment(Department myDepartment) {
		this.myDepartment = myDepartment;
	}
	
	
	
//	@Override
//	public int hashCode()
//	{
//		return email.hashCode();
//	}
//	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if(obj instanceof Employee)
//			return this.getEmail().equals(((Employee)obj).getEmail());
//		return false;
//	}

	public Aadhaar getAadhaarDetails() {
		return aadhaarDetails;
	}

	public void setAadhaarDetails(Aadhaar aadhaarDetails) {
		this.aadhaarDetails = aadhaarDetails;
	}

	public Set<Project> getEmployeeProjects() {
		return employeeProjects;
	}
	
	

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void setEmployeeProjects(Set<Project> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
}
