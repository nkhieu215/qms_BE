package com.fn.qms.rest.bean;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_pow database table.
 * 
 */
@Getter
@Setter
public class StoreCheckPow  {
	private static final long serialVersionUID = 1L;

	
	private Long id;

	private String conclude;

	private String cosFi;

	private String elecCheck;

	private String note;

	private String powCheck;

	private Long workOrderId;
	
	private Long storeCheckId;
}