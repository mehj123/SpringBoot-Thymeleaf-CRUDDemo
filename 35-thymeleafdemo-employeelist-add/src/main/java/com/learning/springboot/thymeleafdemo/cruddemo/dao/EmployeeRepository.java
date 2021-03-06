package com.learning.springboot.thymeleafdemo.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.thymeleafdemo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByLastNameAsc();

}
