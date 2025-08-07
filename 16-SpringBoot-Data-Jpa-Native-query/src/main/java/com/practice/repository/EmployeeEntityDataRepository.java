package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.entity.EmployeeEntityData;


@Repository
public interface EmployeeEntityDataRepository extends JpaRepository<EmployeeEntityData, Integer>{

	
//	@Query(value="select * from EmployeeEntityData ",nativeQuery=true)
//	List<EmployeeEntityData> getAllEmployee();
//	
//	@Query(value="select * from EmployeeEntityData where salary =:salary",nativeQuery=true)
//	EmployeeEntityData getEmployee(@Param("salary") int salary);
	
	@Query(value="select * from EmployeeEntityData e where e.dept =:dept AND e.salary =:salary",nativeQuery=true)
	List<EmployeeEntityData> getEmployeeDeptUsingSalary(@Param("dept") String dept, @Param("salary") int salary);
}
