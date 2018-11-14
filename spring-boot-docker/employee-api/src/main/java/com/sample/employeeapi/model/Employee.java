package com.sample.employeeapi.model;

public class Employee {

	private String employeeId;
	private String employeeName;
	private String unit;
	
	public Employee(String employeeId, String employeeName, String unit) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.unit = unit;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
