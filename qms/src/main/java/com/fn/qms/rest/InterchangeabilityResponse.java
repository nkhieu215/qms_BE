package com.fn.qms.rest;

import com.fn.qms.dto.InterchangeabilityCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InterchangeabilityResponse extends BaseResponse{

	public List<InterchangeabilityCheckDTO> interchangeabilityCheckDTOS;
	public Long idCheck;
	public InterchangeabilityCheckDTO detail;

}
