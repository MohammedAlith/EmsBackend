package com.employeemanagement.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.employeemanagement.system.dto.EmployeeDTO;
import com.employeemanagement.system.entity.Employee;
import com.employeemanagement.system.exception.ResourceNotFoundException;
import com.employeemanagement.system.mapper.EmployeeMapper;
import com.employeemanagement.system.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

   
	
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
       
            Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
            Employee createEmployee = employeeRepository.save(employee);
            return EmployeeMapper.mapToEmployeeDto(createEmployee);
        }

	
	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given Id: "+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}



	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}



	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmployee) {
	    Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
	    		-> new ResourceNotFoundException("Employee is not exist with the given Id: "+employeeId));
	    
	    employee.setName(updateEmployee.getName());
	    employee.setEmail(updateEmployee.getEmail());
	   
	    Employee updatedEmployee = employeeRepository.save(employee);
	    return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}



	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
	    		-> new ResourceNotFoundException("Employee is not exist with the given Id: "+employeeId));
		
		employeeRepository.deleteById (employeeId);
		
	}
	
	
    
	
}
