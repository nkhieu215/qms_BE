package com.fn.qms.planning.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenInput {

	private String username;
	private String password;
	
	public AuthenInput(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
