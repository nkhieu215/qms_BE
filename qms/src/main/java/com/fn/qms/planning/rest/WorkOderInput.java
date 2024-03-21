package com.fn.qms.planning.rest;

import java.util.List;

import com.fn.qms.planning.model.Condition;
import com.fn.qms.planning.model.Filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkOderInput {
	String id;
	
	public Filter filter;
	
}
