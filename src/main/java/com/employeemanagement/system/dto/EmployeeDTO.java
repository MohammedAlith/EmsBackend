package com.employeemanagement.system.dto;





public class EmployeeDTO {
	
  private long id;
  private String name;
  private String email;
  
  
public EmployeeDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public EmployeeDTO(long id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "EmployeeDTO [id=" + id + ", name=" + name + ", email=" + email + "]";
}
 

  

}
