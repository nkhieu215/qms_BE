package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.rest.bean.OitmObj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OitmResponse extends BaseResponse{

	List<OitmObj> lstOitm;
	
}
