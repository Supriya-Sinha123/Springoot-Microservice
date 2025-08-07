package com.practice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;

import com.practice.entity.EmployeeEntityData;
import com.practice.repository.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner loadDbRecords(EmployeeRepository repo) {
		return args ->{
			
			int salary=9999;
			for(int i=0;i<100;i++) {
				
				EmployeeEntityData employeeData = new EmployeeEntityData();
				employeeData.setName("A_" + i);
				employeeData.setDept("Account");
				employeeData.setAddress("Hyd");
				employeeData.setSalary(salary);
				repo.save(employeeData);
				salary++;
			}
			
			int size=10;
//			int page=1;
			
			for(int i=0;i<10;i++) {
				System.out.println("======================page no:"+i+"=========================");
//				PageRequest of=PageRequest.of(i,size,Sort.by("name").ascending());
				PageRequest of=PageRequest.of(i,size);
				Pageable pageable=of;
				Page<EmployeeEntityData> all = repo.findAll(pageable);
				List<EmployeeEntityData> content = all.getContent();
				content.forEach(data ->{
					System.out.println(data);
				});
			}
			
//			PageRequest of = PageRequest.of(page, size, Sort.by("name").ascending());
//			Pageable pageable = of;
//			Page<EmployeeEntityData> all = repo.findAll(pageable);
//			System.out.println(all);
		};
	}

}
