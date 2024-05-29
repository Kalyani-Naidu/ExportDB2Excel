package com.example.db2excel.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEES_INFO")
public class EmployeeInfo {
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private int empId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "GENDER")
	private char gender;
	
	@Column(name = "AGE")
	private String age;
	
	@Column(name = "JOINING_DATE")
	private Date dateOfJoining;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "SALARY")
	private double salary;
	
	@Column(name = "DESIGNATION")
	private String designation;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public EmployeeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeInfo(int empId, String name, char gender, String age, Date dateOfJoining, String department,
			double salary, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
		this.salary = salary;
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", dateOfJoining=" + dateOfJoining + ", department=" + department + ", salary=" + salary
				+ ", designation=" + designation + "]";
	}
	

}