package com.employee.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.data.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
