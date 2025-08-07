package com.practice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.entity.CourseEntity;
import com.practice.entity.StudentEntity;
import com.practice.repository.CourseRepository;
import com.practice.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner loadDbRecords(StudentRepository srepo, CourseRepository crepo) {
		return args ->{
			
			CourseEntity cEntity = new CourseEntity();
			cEntity.setTitle("SpringBoot");
//			crepo.save(cEntity);
			
			CourseEntity cEntity1 = new CourseEntity();
			cEntity1.setTitle("AWS");
//			crepo.save(cEntity1);
			crepo.saveAll(List.of(cEntity, cEntity1));    //if we want to save all at once
			
			StudentEntity sEntity = new StudentEntity();
			sEntity.setName("Supriya");
			sEntity.getCourse().add(cEntity);
			sEntity.getCourse().add(cEntity1);
			
			StudentEntity sEntity1 = new StudentEntity();
			sEntity1.setName("Ragni");
			sEntity1.getCourse().add(cEntity);
			sEntity1.getCourse().add(cEntity1);
			
			srepo.saveAll(List.of(sEntity, sEntity1));
			
			List<StudentEntity> all=srepo.findAll();
			all.forEach(data ->{
				System.out.println(data.getCourse());
			});
		};
	}

}
