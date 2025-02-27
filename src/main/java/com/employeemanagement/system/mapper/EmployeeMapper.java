package com.employeemanagement.system.mapper;

import com.employeemanagement.system.dto.EmployeeDTO;
import com.employeemanagement.system.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO mapToEmployeeDto(Employee employee) {
		return new EmployeeDTO(
				employee.getId(),
				employee.getName(),
				
				employee.getEmail()
				);
		}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDto) {
		return new Employee( 
				employeeDto.getId(),
				employeeDto.getName(),
			    employeeDto.getEmail()
				);
		}
}

