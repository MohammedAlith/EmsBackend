package com.employeemanagement.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.system.dto.EmployeeDTO;
import com.employeemanagement.system.service.EmployeeService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Validated @RequestBody EmployeeDTO employeeDto) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
   
    // Build Get Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
    	EmployeeDTO employeeDto = employeeService.getEmployeeById(employeeId);
    	return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    
    // Build Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
    	List<EmployeeDTO> employees = employeeService.getAllEmployees();
    	return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO updatedEmployee){
    	EmployeeDTO employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
    	return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    
  //Build Delete Employee REST API
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    	employeeService.deleteEmployee(employeeId);
    	return ResponseEntity.ok("Employee Deleted successfully");
    }
    
}
