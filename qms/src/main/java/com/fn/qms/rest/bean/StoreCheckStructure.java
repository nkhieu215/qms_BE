package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_store_structure database table.
 * 
 */
@Getter
@Setter
public class StoreCheckStructure {	
	private Long id;
	private String checkPerson;
	private String conclude;
	private String note;
	private String quatity;	
	private int workOrderId;
	private Long storeCheckId;	
	public StoreCheckStructure() {
	}


}