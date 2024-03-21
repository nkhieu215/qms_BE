package com.fn.qms.rest.iqc;

import java.util.List;


import com.fn.qms.dto.PqcCriteriaQualityDTO;
import com.fn.qms.rest.BaseRequest;
import com.fn.qms.rest.bean.IqcCriteriaLkdt;
import com.fn.qms.rest.bean.IqcCriteriaNvl;
import com.fn.qms.rest.bean.IqcParameter;
import com.fn.qms.models.IqcAuditCriteriaLkdt;
import com.fn.qms.models.IqcAuditCriteriaParameter;
import com.fn.qms.models.PqcCriteriaQuality;
import com.fn.qms.rest.bean.Examination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationRequest extends BaseRequest {
	
	// type request
	private String code;
	private Examination examination;
	private List<IqcAuditCriteriaLkdt> lstCriteriaLkdt;
	private List<IqcCriteriaNvl> lsCriteriaNvl;
	private List<IqcAuditCriteriaParameter> lstParameter;
	private List<PqcCriteriaQualityDTO> lstCriteriaQualities;
	
	private Integer type;
	
	// note
	private String note;
}
