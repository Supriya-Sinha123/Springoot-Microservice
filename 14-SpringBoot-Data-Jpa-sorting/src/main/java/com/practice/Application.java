package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.practice.entity.EmployeeEntity;
import com.practice.repository.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner loadDbRecords(EmployeeRepository repo) {
		return args ->{
			
			List<String> list = new ArrayList<>();
			list.add("Supriya");
			list.add("Abhijeet");
			list.add("Sima");
			list.add("Ragni");
			list.add("Deepika");
			int salary=9999;
			
			for(int i=0;i<5;i++) {
				
				EmployeeEntity employeeEntity = new EmployeeEntity();
				employeeEntity.setName(list.get(i));
				employeeEntity.setDept("IT");
				employeeEntity.setSalary(salary);
				employeeEntity.setAddress("xzy");
				
				repo.save(employeeEntity);
				salary +=1;
			}
			
			
			//sorting is salary default
			List<EmployeeEntity> all = repo.findAll(Sort.by("salary"));
			all.forEach(data ->{
				System.out.println(data);
			});
			
			//sorting in descending order
			List<EmployeeEntity> all1 = repo.findAll(Sort.by(Sort.Direction.DESC, "salary"));
			all1.forEach(data ->{
				System.out.println(data);
			});
			
		};
	}

}
