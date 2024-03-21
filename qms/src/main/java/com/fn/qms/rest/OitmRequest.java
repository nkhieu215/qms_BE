package com.fn.qms.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OitmRequest extends BaseRequest{
	
	// type request
	private String typeRequest;
		
	// brows
	private Integer page;
	private Integer size;		
	private Integer type;
	
	private String code;
}
