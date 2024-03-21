package com.fn.qms.rest;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApproveCheckRequest extends BaseRequest{
	private String note;
	private String approveStatus;
	private String name;
	private String type;
	private Long checkId;
}
