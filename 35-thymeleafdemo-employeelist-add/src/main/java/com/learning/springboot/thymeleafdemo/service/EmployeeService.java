package com.learning.springboot.thymeleafdemo.service;

import java.util.List;

import com.learning.springboot.thymeleafdemo.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save (Employee employee);
	
	public void deleteById(int id);

}
