package com.practice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.entity.EmployeeEntityData;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntityData, Integer>{

	
	@Query(value="Select * from employee", nativeQuery=true)
	List<EmployeeEntityData> getAllEmployee();
	
	Page<EmployeeEntityData> findAll(Pageable pageable);
	
	@Query(value="select e from employee e where e.salary =:salary", nativeQuery=true)
	EmployeeEntityData getEmployee(@Param("salary")int salary);
	
	@Query(value="select e from employee e where e.dept =:dept AND e.salary =:salary",nativeQuery=true)
	List<EmployeeEntityData> getEmployeeUsing(@Param("dept")String dept,@Param("salary")int salary);
}
