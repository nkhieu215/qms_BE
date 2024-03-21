package com.fn.qms.rest;

import com.fn.qms.dto.StepCheckDTO;
import com.fn.qms.dto.StepProcessDTO;
import com.fn.rd.models.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StepProcessResponse extends BaseResponse{

	private List<StepProcessDTO> lstStep;
}
