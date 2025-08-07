package com.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.entity.ProfileEntity;
import com.practice.entity.UsersEntity;
import com.practice.repository.ProfileRepository;
import com.practice.repository.UsersRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	CommandLineRunner loadDbRecords(UsersRepository urepo, ProfileRepository prepo) {
		return args ->{
			ProfileEntity pEntity = new ProfileEntity();
//			ProfileEntity pEntity1 = new ProfileEntity();
			UsersEntity uEntity = new UsersEntity();
			
			pEntity.setBio("full stack developer");
			pEntity.setPhone("98634527");
			
//			pEntity1.setBio("Mern stack");
//			pEntity1.setPhone("54739200");
			
			uEntity.setName("Supriya");
			uEntity.setProfile(pEntity);
			
			UsersEntity save = urepo.save(uEntity);
//			UsersEntity save = urepo.save(pEntity1);
			System.out.println(save);
		};
	}
	
}
