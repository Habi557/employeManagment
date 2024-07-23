package com.employemanagment.services;

import java.util.List;

import com.employemanagment.dto.Employee;

public interface EmployeService {
	
	public List<Employee> getAllEmployees();
	public Employee updateEmploye(int id);

}
