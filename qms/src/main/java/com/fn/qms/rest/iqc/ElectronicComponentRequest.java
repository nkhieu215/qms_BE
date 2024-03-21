package com.fn.qms.rest.iqc;

import java.util.List;

import com.fn.qms.dto.iqc.nvl.*;
import com.fn.qms.models.IqcAuditCriteriaLkdt;
import com.fn.qms.models.IqcAuditCriteriaNvl;
import com.fn.qms.models.IqcAuditResultLkdt;
import com.fn.qms.models.IqcAuditResultNvl;
import com.fn.qms.models.IqcAuditResultParameter;
import com.fn.qms.models.IqcElectCompErr;
import com.fn.qms.models.IqcElectronicComponent;

import com.fn.qms.rest.BaseRequest;
import com.fn.qms.rest.bean.IqcSearchParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicComponentRequest extends BaseRequest {
	
	private String status; // DRAFF: nhÃ¡p , APPROVE: Ä‘Ã£ duyá»‡t, WAIT_APPROVE: chá»� phÃª duyá»‡t
	private String type;

	private IqcSearchParam param;
	IqcAuditResultNvlDTO nvlParam;
	IqcElectCompErrDTO errParam;


	private IqcElectronicComponentDTO component;
	private List<IqcAuditResultParameterDTO> lstIqcParam;
	private List<IqcAuditResultLkdtDTO> lstIqcLkdt;
	private List<IqcAuditResultNvlDTO> lstIqcNvl;
	private List<IqcElectCompErrDTO> lstError;
}
