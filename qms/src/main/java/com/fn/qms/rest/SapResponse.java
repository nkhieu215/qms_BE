package com.fn.qms.rest;

import java.util.List;

import com.fn.sap.models.Coitt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SapResponse extends BaseResponse{

	List<Coitt> lstOitt;
	Coitt coitt;
	
}
