package com.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice.entity.AuthorEntity;
import com.practice.entity.BookEntity;
import com.practice.repository.AuthorRepository;
import com.practice.repository.BookRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean 
	CommandLineRunner loadDbRecords(AuthorRepository arepo, BookRepository brepo) {
		return args ->{
			
			
			AuthorEntity author = new AuthorEntity();
//			AuthorEntity author1 = new AuthorEntity();
			BookEntity book1 = new BookEntity();
			BookEntity book2 = new BookEntity();
			
			author.setName("William Shakespeare");
			arepo.save(author);
			
			book1.setTitle("Hamlet");
			book1.setAuthor(author);
			brepo.save(book1);
			
			book2.setTitle("Romeo And Julite");
			book2.setAuthor(author);
			brepo.save(book2);
			
			System.out.println("Insertion successfully");
			
			
		};
	}

}
