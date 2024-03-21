package com.fn.rd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "SELECT i FROM Employee i")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	private String mail;
	
	@Column(name = "employee_code")
	private String employeeCode;
	
	@Column(name = "user_name")
	private String userName;
	
	private String status;
}
