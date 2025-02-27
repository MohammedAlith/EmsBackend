package com.employeemanagement.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.employeemanagement.system.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
}
