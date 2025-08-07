package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.EmployeeEntity;
import com.practice.entity.EmployeeId;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeeId>{

}
