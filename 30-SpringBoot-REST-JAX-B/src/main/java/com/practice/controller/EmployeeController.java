package com.practice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DTO.EmployeeDTO;
import com.practice.service.EmployeeService;

import jakarta.xml.bind.JAXBException;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/marshalling")
	public String marshal() throws JAXBException {
		EmployeeDTO employee = new EmployeeDTO(101, "Supriya", "admin123", 1250.00, Arrays.asList("java", "sql", "aws"));
		String marshalling = employeeService.marshalling(employee);
		return marshalling;
	}
	
	
	@GetMapping(value="/unmarshalling")
	public EmployeeDTO unmarshal() throws JAXBException {
		String xml =  "<employee>\r\n" + 
	                  "<id>1001</id>\r\n" + 
				      "<name>raja</name>\r\n" + 
				      "<password>admin123</password>\r\n" + 
	                  "<salary>34567.0</salary>\r\n" +
				      "<skills>\r\n" + 
	                  "<skill>java</skill>\r\n" + 
				      "<skill>spring boot</skill>\r\n"+ 
	                  "<skill>REST</skill>\r\n" + 
				      "</skills>\r\n" + 
	                  "</employee>";
		EmployeeDTO unmarshalling = employeeService.unmarshalling(xml);
		System.out.println(unmarshalling);
		return unmarshalling;
	}
}
