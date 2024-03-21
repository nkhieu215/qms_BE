package com.fn.qms.rest;


import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

@Getter
@Setter
public class StoreSapApproveRequest extends BaseRequest{
	
	private String name;
	Long storeId;
	String action;
	String note;

	String doituong;
	String khoBh;
	String khonhap;

	String quantityStoreSap;
	String dateApproveSap;
	String statusSap;
}
