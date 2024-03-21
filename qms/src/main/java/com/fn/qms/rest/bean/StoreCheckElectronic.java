package com.fn.qms.rest.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreCheckElectronic {

	// thong tin workorder
	private Long id;
	private String cosFi;
	private String elecCheck;
	private String note;
	private String powCheck;
	private Long workOrderId;
	private Long storeCheckId;
	private Long quantityCheck;
}
