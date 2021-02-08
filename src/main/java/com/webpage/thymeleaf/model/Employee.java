package com.webpage.thymeleaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employee")
public class Employee {
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	@Id
	@Column
	private  int employeeId;
	@Column
	private String forename;
	@Column
	private String surname;
	@Column
	private int age;
	@Column
	private String company;
	@Column
	private int postcode;

	public Employee() {}
	
	Employee(int employeeId,String forename,String surname,int age,String company,int postcode){
		this.employeeId = employeeId;
		this.forename = forename;
		this.surname = surname;
		this.age = age;
		this.company = company;
		this.postcode = postcode;
	}
}
