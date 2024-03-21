package com.fn.qms.rest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScadaAssetsRequest {

	String type;
	String textSearch;
	String sortProperty;
	String sortOrder;
	Integer pageSize;
	Integer page;
	
	String entityType;
	String entityId;

}
