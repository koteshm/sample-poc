package com.sample.employeeapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sample.employeeapi.model.Employee;

@Service
public class EmployeeSerivce {
	
	private Map<String, Employee> employees = new HashMap<>();
	
	public EmployeeSerivce () {
		employees.put("100", new Employee("100", "kotesh","unit-1"));
		employees.put("101", new Employee("101", "Satish","unit-2"));
		employees.put("102", new Employee("102", "suresh","unit-3"));
	}
	
	public Employee getEmployee(String employeeId) {
		return employees.get(employeeId);
	}
	
	public Employee createEmployee(Employee employee) {
		employees.put(employee.getEmployeeId(), employee);
		return employees.get(employee.getEmployeeId());
	}

}
