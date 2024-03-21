package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.StepCheckDTO;
import com.fn.qms.dto.WoDTO;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcWorkOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PqcWorkOrderResponse extends BaseResponse{
	List<WoDTO> lstOrder;
	List<PqcErrorList> errList;
	List<StepCheckDTO> lstCheck;
}
