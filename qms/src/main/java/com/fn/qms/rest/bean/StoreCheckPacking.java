package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_store_pow database table.
 * 
 */
@Getter
@Setter
public class StoreCheckPacking  {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String packing;
	private String powCheck;
	private Long workOrderId;	
	private Long storeCheckId;

}