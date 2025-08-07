package com.practice.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.entity.EmployeeEntity;
import com.practice.entity.EmployeeId;
import com.practice.repository.EmployeeRepository;

@Component
public class EmployeeComponent {
	
	@Autowired
	private EmployeeRepository repo;

	public void create() {
		EmployeeId emp1 = new EmployeeId(101l, 1l);
		EmployeeEntity entity1 = new EmployeeEntity(emp1,"Supriya","QA");
		
		EmployeeId emp2 = new EmployeeId(102l, 1l);
		EmployeeEntity entity2 = new EmployeeEntity(emp2,"Ragni","Developer");
		
		repo.save(entity1);
		repo.save(entity2);
	}
}
