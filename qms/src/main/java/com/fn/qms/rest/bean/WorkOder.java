package com.fn.qms.rest.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkOder {

	// thong tin workorder
	private String bomVersion;
	private String branchCode;
	private String branchName;
	private Date createTime;
	private Date endTime;
	private String groupCode;
	private String groupName;
	private String line;
	private String lotNumber;
	private String planningWorkOrderId;
	private String productCode;
	private String productName;
	private Integer productType;
	private String productOrder;
	private String quantityPlan;
	private Date startTime;
	private String woId;
	private Long id;
	private String profileCode;
	private String  profileName;
	private String  profileId;
	private String sapWo;
	private String udocURL;
	private String udocURL2;

	private String startDate;
	private String endDate;
}
