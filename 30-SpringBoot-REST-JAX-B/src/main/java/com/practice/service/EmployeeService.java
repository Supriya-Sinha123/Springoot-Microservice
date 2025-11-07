package com.practice.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.stereotype.Service;

import com.practice.DTO.EmployeeDTO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

//JAX-B service
@Service
public class EmployeeService {

	
	//marshalling
	
	public String marshalling(EmployeeDTO emp) throws JAXBException {
		//jaxb context
		JAXBContext jaxBInstance = JAXBContext.newInstance(EmployeeDTO.class);
		Marshaller marshaller = jaxBInstance.createMarshaller();
		
		//java ---> xml
		StringWriter writer = new StringWriter();
		marshaller.marshal(emp, writer);
		
		return writer.toString();
	}
	
	//unmarshalling
	
	public EmployeeDTO unmarshalling(String xml) throws JAXBException {
		//jaxb context
		JAXBContext jaxBInstance = JAXBContext.newInstance(EmployeeDTO.class);
		Unmarshaller unmarshalling = jaxBInstance.createUnmarshaller();
		
//		xml ----> java
		StringReader reader = new StringReader(xml);
		EmployeeDTO unmarshal = (EmployeeDTO) unmarshalling.unmarshal(reader);
		
		return unmarshal;
	}
}
