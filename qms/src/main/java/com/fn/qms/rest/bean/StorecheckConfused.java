package com.fn.qms.rest.bean;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_confused database table.
 * 
 */
@Getter
@Setter
public class StorecheckConfused {
	private static final long serialVersionUID = 1L;

	
	private Long id;	
	private String checkPerson;
	private String conclude;
	private String note;
	private String quatity;
	private Long workOrderId;
	private Long storeCheckId;
	
	

}