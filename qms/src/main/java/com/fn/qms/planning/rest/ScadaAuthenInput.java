package com.fn.qms.planning.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScadaAuthenInput {

	private String username;
	private String password;

	public ScadaAuthenInput(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
