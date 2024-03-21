package com.fn.qms.rest.bean;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_err database table.
 * 
 */
@Setter
@Getter
public class StoreCheckErr{
	private static final long serialVersionUID = 1L;	
	private Long id;
	private String checkPerson;
	private String err;
	private String grErr;
	private String line;
	private String quatity;
	private String note;
	private String lot;
	private Long storeCheckId;

}