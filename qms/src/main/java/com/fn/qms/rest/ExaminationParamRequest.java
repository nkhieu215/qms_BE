package com.fn.qms.rest;

import com.fn.qms.models.IqcAuditCriteriaLkdt;
import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditCriteriaParameter;

import com.fn.qms.models.PqcCriteriaQuality;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationParamRequest extends BaseRequest{
	
	// type request
	private String typeRequest; //1 : lkdt, 2: nvl , 3: param
	private String action; // 0: delete ,  1 edit, 2: new
	
	// add or edit	
	private Long id;
	private IqcAuditCriteriaLkdt criteriaLkdt;
	private IqcAuditCriteriaNvl criteriaNvl;
	private IqcAuditCriteriaParameter parameter;
	private PqcCriteriaQuality qualities;
}
