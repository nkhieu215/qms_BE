package com.fn.qms.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {

	// type request
	private String typeRequest;

	// brows
	private Integer page;
	private Integer size;
	private String name;
	private String date;
	private String prodCode;
	private String lot;
	private String woCode;
	private String search;

	// add or edit
	private Long id;
	private String step;

}
