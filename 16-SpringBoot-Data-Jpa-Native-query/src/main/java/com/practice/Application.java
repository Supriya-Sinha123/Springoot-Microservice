package com.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.entity.EmployeeEntityData;
import com.practice.repository.EmployeeEntityDataRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner loadDbRecords(EmployeeEntityDataRepository repo) {
		return args ->{
			List<String> list = new ArrayList<>();
			list.add("Sima");
			list.add("Supriya");
			list.add("Abhi");
			list.add("Archu");
			list.add("Ragni");
			int salary=9999;
			
            for(int i=0;i<5;i++) {
				
		    EmployeeEntityData entityData = new EmployeeEntityData();
				
			entityData.setName(list.get(i));
			entityData.setDept("account");
			entityData.setSalary(salary);
			entityData.setAddress("xyz");
			repo.save(entityData);
			salary++;
			}
            
//          List<EmployeeEntityData> allEmployee = repo.getAllEmployee();
//			allEmployee.forEach(data ->{
//				System.out.println(data);
//			});
			
//			EmployeeEntityData employee = repo.getEmployee(9999);
//			System.out.println(employee);
			
			
			List<EmployeeEntityData> employee = repo.getEmployeeDeptUsingSalary("account", 10001);
			System.out.println(employee);
		};
	}

}