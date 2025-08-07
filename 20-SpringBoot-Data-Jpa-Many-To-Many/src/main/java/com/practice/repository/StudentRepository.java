package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
