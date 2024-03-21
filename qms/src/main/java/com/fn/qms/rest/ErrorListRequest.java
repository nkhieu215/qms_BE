package com.fn.qms.rest;

import com.fn.qms.rest.bean.ErrorListBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorListRequest extends BaseRequest{
	
	private Long id;
	//
	private String name;
	private String code;
	
	// type request
	private String typeRequest;
		
	// brows

	private Integer size;		
	private String type;


	String textSearch;
	String sortProperty;
	String sortOrder;
	Integer pageSize;

	//
	private ErrorListBean errorBean;
}
