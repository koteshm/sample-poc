package com.sample.employeeapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.employeeapi.model.Employee;
import com.sample.employeeapi.service.EmployeeSerivce;

@RestController
public class EmployeeController {
	
@Autowired
private EmployeeSerivce service;


@RequestMapping(path="/employees/{id}", method=RequestMethod.GET)
public Employee getEmployee(@PathVariable("id") String employeeId) {
	return service.getEmployee(employeeId);
}

@RequestMapping(path="/employees", method=RequestMethod.POST)
public Employee getEmployee(@RequestBody Employee employee) {
	return service.createEmployee(employee);
}

}
