package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

}
