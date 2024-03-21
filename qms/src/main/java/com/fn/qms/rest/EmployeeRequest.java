package com.fn.qms.rest;

import java.util.List;


import com.fn.qms.rest.bean.IqcCriteriaLkdt;
import com.fn.qms.rest.bean.IqcCriteriaNvl;
import com.fn.qms.rest.bean.IqcParameter;
import com.fn.qms.rest.bean.Examination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest extends BaseRequest{
	
	private String name;	
}
