package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.DrawNvlImageDTO;
import com.fn.qms.dto.DrawTestNvlDTO;

import com.fn.qms.dto.PqcDrawNvlTestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NvlResponse extends BaseResponse{
	private Long id;
	private String note;
	private String conclude;
	private String checkPerson;
	private Long workOrderId;
	
	private List<PqcDrawNvlTestDTO> lstDraw;
	private List<DrawNvlImageDTO> lstImg;
}
