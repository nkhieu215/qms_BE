package com.fn.qms.rest;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReportErrorRequest extends BaseRequest{
	private String name;
	private String code;
	private String grErr;
	private String err;
	private String woCode;
	private Date startDate;
	private Date endDate;

	private String branchName;
	private String groupName;
}
