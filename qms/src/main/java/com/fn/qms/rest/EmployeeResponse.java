package com.fn.qms.rest;

import java.util.List;

import com.fn.rd.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse extends BaseResponse{

	private Employee employee;
	private List<Employee> lstEmployee;
}
