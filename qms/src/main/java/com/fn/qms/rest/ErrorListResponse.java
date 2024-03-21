package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.ErrorDTO;
import com.fn.qms.dto.ErrorGRDTO;
import com.fn.rd.models.ErrorList;

import com.fn.scada.dto.ScadaAssetsData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorListResponse extends BaseResponse{

	private List<ErrorList> lstError;
	private List<ErrorGRDTO> lstGr;
	private List<ErrorDTO> lstErrorScada;
	private ErrorList error;
	List<ScadaAssetsData> data;
}
