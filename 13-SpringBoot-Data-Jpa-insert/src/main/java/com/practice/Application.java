package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.entity.StudentEntity;
import com.practice.repository.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("Supriya");
        studentEntity.setStream("IT");
        studentEntity.setContactNo(987654321);
        studentEntity.setAge(21);
        studentEntity.setAddress("XYZ");

        repo.save(studentEntity);
        System.out.println("Student saved successfully!");
    }
}
