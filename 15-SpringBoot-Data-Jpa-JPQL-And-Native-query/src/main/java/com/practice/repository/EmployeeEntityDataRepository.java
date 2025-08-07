package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.entity.EmployeeEntityData;

public interface EmployeeEntityDataRepository extends JpaRepository<EmployeeEntityData, Integer>{

	@Query("select e from EmployeeEntityData e")
	List<EmployeeEntityData> getAllEmployee();
	
	@Query("select e from EmployeeEntityData e where e.salary =:salary")
	EmployeeEntityData getEmployee(@Param("salary") int salary);
	
	@Query("select e from EmployeeEntityData e where e.dept =:dept AND e.salary =:salary")
	List<EmployeeEntityData> getEmployeeDeptUsingSalary(@Param("dept") String dept, @Param("salary") int salary);
}
