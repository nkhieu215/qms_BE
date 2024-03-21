package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_store_safe database table.
 * 
 */
@Getter
@Setter
public class StoreCheckSafe {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String checkPerson;
	private String conclude;
	private String note;
	private String quatity;
	private int workOrderId;
	private Long storeCheckId;

	private String standard;
}