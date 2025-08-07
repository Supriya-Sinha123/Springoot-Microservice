package com.practice.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
//import lombok.Data;
import lombok.ToString;

@Entity
//@Data
@Table(name="student")
@ToString(exclude="course")
public class StudentEntity {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable( name="student_course",
	joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")
	)
	private Set<CourseEntity> course=new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(Set<CourseEntity> course) {
		this.course = course;
	}
	
	
}
