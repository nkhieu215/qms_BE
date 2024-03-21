package com.fn.qms.planning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {

	public String property;
	public String operator;
	public Object value;


	public Condition(String property, String operator, Object value) {
		super();
		this.property = property;
		this.operator = operator;
		this.value = value;
	}
	
	
}
