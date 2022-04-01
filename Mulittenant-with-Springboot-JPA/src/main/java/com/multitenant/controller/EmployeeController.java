package com.multitenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multitenant.model.Employee;
import com.multitenant.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("employeeList")
	public List<Employee> emploeeList() {
		return employeeRepository.findAll();
	}

	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam Integer employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee Deleted Successfully";
	}

	@GetMapping("getEmployeeById")
	public Employee getEmployeeById(@RequestParam Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}
}
