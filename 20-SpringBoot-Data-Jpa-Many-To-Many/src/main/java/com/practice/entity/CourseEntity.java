package com.practice.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="courses")
@ToString(exclude="student")
public class CourseEntity {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	
	@ManyToMany(mappedBy="course")
	private Set<StudentEntity> student=new HashSet<>();
}
