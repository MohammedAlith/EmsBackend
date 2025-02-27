package com.employeemanagement.system.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees_list")


public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="employeeid", nullable = false, unique = true)
	private long id;
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long id, String name,  String email) {
		super();
		this.id = id;
		this.name = name;
		
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ",  email=" + email + "]";
	}
	
}
