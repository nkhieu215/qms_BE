package com.fn.qms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NvlCreateDTO {
	
	private Long id;
	private String note;
	private String conclude;
	private String checkPerson;
	private Long workOrderId;
	
	private List<DrawTestNvlDTO> lstPqcDrawNvl;
		
}
