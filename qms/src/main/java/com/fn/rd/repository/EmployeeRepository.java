package com.fn.rd.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fn.qms.models.IqcElectronicComponent;
import com.fn.rd.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT t FROM Employee t where (:userName is NULL OR t.userName like %:userName%) order by userName asc")
	List<Employee> searchByName(@Param("userName")String userName);
}