package com.employee.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.Entity.Employee;
import com.employee.data.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService; 
	
	@GetMapping("/customers")
	ResponseEntity<List<Employee>> get(){
		try {
			List<Employee> list = (List<Employee>) employeeService.get();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> getCustomer(@PathVariable Long employeeId) {
		Optional<Employee> employee = employeeService.get(employeeId);
		
		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveCustomer(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<Employee>(employeeService.add(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateCustomer(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<Employee>(employeeService.add(employee), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long employeeId) {
		try {
			employeeService.delete(employeeId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
