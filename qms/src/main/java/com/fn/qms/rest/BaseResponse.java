package com.fn.qms.rest;

import com.fn.qms.base.validator.Validator;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseResponse {

	Validator.Result result;
	Integer totalPages;
	Integer totalElements;
	Boolean hasNext;
	int total;
	Long id;
	Date createdAt;
	Date updatedAt;
}
