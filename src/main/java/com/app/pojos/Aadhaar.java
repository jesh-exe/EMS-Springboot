package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Aadhaar {

	@Column(name = "aadhaar_no",length = 12,unique = true,nullable = false)
	private String aadhaarNumber;
	@Column(name = "creation_date",nullable = false)
	private LocalDate creationDate;
	
	public Aadhaar() {
		// TODO Auto-generated constructor stub
	}
	
	public Aadhaar(String aadhaarNumber, String creationDate) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.creationDate = LocalDate.parse(creationDate);
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		return "Aadhaar [aadhaarNumber=" + aadhaarNumber + ", creationDate=" + creationDate + 
				"]";
	}
	
	
	
}
