package com.fn.qms.rest;

import com.fn.qms.dto.AqlTemplateDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AqlTemplateResponse extends BaseResponse{
	AqlTemplateDTO dto;
	public List<AqlTemplateDTO> lstTemplate;
}
