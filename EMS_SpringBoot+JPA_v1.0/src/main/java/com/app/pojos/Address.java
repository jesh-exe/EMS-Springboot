package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity{

	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String state;
	@Column(name = "zip_code",nullable = false)
	private long zipCode;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "emp_id")
	@MapsId					//It is used to make the id of address as PK as well as FK for the employee id (Combined Key) as it has
									//OneToOne Relationship,thus there will be only 1 record of address per employee
	private Employee emp;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String city, String country, String state, long zipCode) {
		super();
		this.city = city;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
	}

	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", state=" + state + ", zipCode=" + zipCode + ", emp="
				+ emp.getEmail() + "]";
	}
	
	
	
}
