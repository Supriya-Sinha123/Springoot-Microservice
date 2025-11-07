package com.practice.DTO;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name= "employee")
@XmlType(propOrder={"id","name","salary","skills"})
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDTO {

	@XmlAttribute
	private int id;
	private String name;
	
	@XmlTransient
	private String password;
	private double salary;
	
	@XmlElementWrapper(name="skills")
	private List<String> skills;
	
	
	public EmployeeDTO() {
		
	}
	
	public EmployeeDTO(int id, String name, String password, double salary, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.salary = salary;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", password=" + password + ", salary=" + salary
				+ ", skills=" + skills + "]";
	}
	
	
	
	
//	@XmlElement
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	@XmlElement
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	@XmlTransient
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@XmlElement
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//	
//	@XmlElement(name="skill")
//	@XmlElementWrapper(name="skills")
//	public List<String> getSkills() {
//		return skills;
//	}
//	public void setSkills(List<String> skills) {
//		this.skills = skills;
//	}
	
	
	
}
