package com.fn.qms.rest;

import com.fn.qms.dto.StepProcessDTO;
import com.fn.qms.dto.StepStatusDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StepStatusResponse extends BaseResponse{

	private List<StepStatusDTO> lstStep;
}
