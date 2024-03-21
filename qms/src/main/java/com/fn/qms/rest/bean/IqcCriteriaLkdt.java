package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcCriteriaLkdt {

	private Long id;
	private String auditContent;
	private String regulationLevel;
	private String technicalRequirement;
	
	private Long templateId;
}
