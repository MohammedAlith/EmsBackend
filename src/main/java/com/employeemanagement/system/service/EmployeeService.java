package com.employeemanagement.system.service;

import java.util.List;

import com.employeemanagement.system.dto.EmployeeDTO;

public interface EmployeeService {
  EmployeeDTO createEmployee(EmployeeDTO employeeDto);
  
  EmployeeDTO getEmployeeById(Long employeeId);
  
  List<EmployeeDTO> getAllEmployees();
  
  EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmployee);
  
  void deleteEmployee(Long employeeId);
  
}
