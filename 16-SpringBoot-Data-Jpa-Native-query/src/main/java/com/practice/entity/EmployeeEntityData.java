package com.practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="employee")
public class EmployeeEntityData {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empid", nullable=false, length=100)
	private int id;
	private String name;
	private String dept;
	private int salary;
	private String address;
}
