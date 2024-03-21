package com.fn.qms.repository.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fn.rd.models.Employee;
import com.fn.rd.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> searchEmployee(String name){
		return repository.searchByName(name);
	}

}
