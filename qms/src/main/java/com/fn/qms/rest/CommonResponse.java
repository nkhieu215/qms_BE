package com.fn.qms.rest;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse extends BaseResponse{
	private Object obj;
	private List<Object> lstObj;
}
