package com.employee.data.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.data.Entity.Employee;
import com.employee.data.repository.EmployeeRepository;

import antlr.collections.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee add(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List get() {

		return (List) employeeRepository.findAll();
	}

	@Override
	public Optional get(Long employeeId) {

		return employeeRepository.findById(employeeId);
	}

	@Override
	public void delete(Long employeeId) {
		// TODO Auto-generated method stub

		if (get(employeeId).isPresent()) {
			employeeRepository.delete((Employee) get(employeeId).get());
		}
	}

}
