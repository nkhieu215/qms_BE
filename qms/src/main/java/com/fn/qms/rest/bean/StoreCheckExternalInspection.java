package com.fn.qms.rest.bean;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_external_inspection database table.
 * 
 */
@Setter
@Getter
public class StoreCheckExternalInspection{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String allow;
	private String conclude;
	private String reality;
	private String testLevel;
	private Date updatedAt;
	private int workOrderId;
	private Long storeCheckId;	
	private String note;
	private Long quantity;
	private String acceptanceLevel;

}