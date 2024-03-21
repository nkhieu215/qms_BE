package com.fn.qms.planning.rest;

import com.fn.qms.planning.model.Filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanningFilterInput {
	private String sort;
	Integer limit;
	Integer offset;
	private Filter filter;
}
