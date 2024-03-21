package com.fn.qms.rest.iqc;

import java.util.List;

import com.fn.qms.dto.PqcCriteriaQualityDTO;
import com.fn.qms.dto.iqc.nvl.IqcExaminationDTO;

import com.fn.qms.models.IqcExaminationType;
import com.fn.qms.rest.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExaminationResponse extends BaseResponse {
	private List<IqcExaminationDTO> lstExamination;
	private List<PqcCriteriaQualityDTO> lstPqcCriteriaQualities;

	private IqcExaminationDTO examinationType;
}
