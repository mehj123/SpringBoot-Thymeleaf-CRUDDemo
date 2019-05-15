package com.learning.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.springboot.thymeleafdemo.cruddemo.entity.Employee;
import com.learning.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees",employees);
		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
