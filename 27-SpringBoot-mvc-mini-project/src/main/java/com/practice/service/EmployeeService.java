package com.practice.service;

import java.util.List;

import com.practice.dto.EmployeeDTO;


public interface EmployeeService {

	
	public EmployeeDTO registerEmployee(EmployeeDTO employee);
	public EmployeeDTO updateEmployee(EmployeeDTO employee);
	public EmployeeDTO fetchEmployeeById(long id);
	public List<EmployeeDTO> fetchAllEmployee();
	public void deleteEmployee(long id);
	
	//login------------------------------------------------------------------
	
	public String loginEmployee(String email, String password);
}
