package com.employee.data.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.data.Entity.Employee;

import antlr.collections.List;


public interface EmployeeService {

	Employee add(Employee employee);
	List get();
	Optional get(Long employeeId);
	
	void delete(Long employeeId);
}
