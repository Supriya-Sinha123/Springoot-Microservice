package com.practice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.EmployeeDTO;

import com.practice.entity.EmployeeEntity;
import com.practice.exceptionHandling.UserNotFoundException;
import com.practice.repository.EmployeeRepository;
import com.practice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public EmployeeDTO registerEmployee(EmployeeDTO employee) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		EmployeeEntity save = employeeRepo.save(entity);
		BeanUtils.copyProperties(save, employee);
		return employee;
	}
	

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employee) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		EmployeeEntity save = employeeRepo.save(entity);
		BeanUtils.copyProperties(save, employee);
		return employee;
	}

	@Override
	public EmployeeDTO fetchEmployeeById(long id) {
		EmployeeDTO dto = new EmployeeDTO();
		Optional<EmployeeEntity> byId = employeeRepo.findById(id);
		if(byId.isPresent()) {
			BeanUtils.copyProperties(byId.get(), dto);
		}
		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchAllEmployee() {
		List<EmployeeDTO> employees = new ArrayList<>();
		List<EmployeeEntity> allEmployee = employeeRepo.findAll();
		allEmployee.forEach(data ->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(data, dto);
			employees.add(dto);
		});
		return employees;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
		
	}
	
	//login-----------------------------------------------------------------
	
	@Override
	public String loginEmployee(String email, String password) {
//		System.out.println("Login attempt: " + email + " / " + password);
		Optional<EmployeeEntity> byEmailAndPassword = employeeRepo.findByEmailAndPassword(email, password);
//		System.out.println("Query result: " + byEmailAndPassword);
		if(byEmailAndPassword.isPresent()) {
			return "success";
		}
		    throw new UserNotFoundException("This employee is not found. Or your username & password is incorrect");
	}

}
