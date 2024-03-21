package com.fn.qms.rest;

import com.fn.qms.dto.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SapCommonResponse extends BaseResponse{
	public List<SapBPGroupDTO> lstBpGroupDTOS;
	List<OwhsDTO> lstOwhsDTOS;
	List<KhoBhDTO> lstKhoBhDTOS;

	List<ColorDTO> lstColor;
	List <OcrdDTO> lstOcrd;
}
