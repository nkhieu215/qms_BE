package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class StoreCheck {

	// thong tin workorder
	private Long id;
	private String checkDate;
	private String checkPerson;
	private String lot;
	private String quatity;
	private String quatityStore;
	private String totalErr;
	private Long workOrderId;
	private String note;
	private String conclude;
	private String statusApproveSap;
	private String idApprovePlaning;
	private String status;

	private String colorName;

	private String colorCode;

	private String quantityStoreSap;
	private String dateApproveSap;
	private Date createdAt;
	private String hisString;

}
