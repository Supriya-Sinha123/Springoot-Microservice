//package com.practice.component;
//
//import org.springframework.stereotype.Service;
//
//import com.practice.entity.StudentEntity;
//import com.practice.repository.StudentRepository;
//
//@Service
//public class StudentComponent {
//	
//	private StudentRepository studentRepository;
//
//	public StudentComponent(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}
//	
//	
//	public void saveStudent(StudentEntity student) {
//		studentRepository.save(student);
//	}
//	
//	public StudentEntity findByName(String name) {
//		return studentRepository.findByName(name);
//		
//	}
//
//}
