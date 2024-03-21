package com.fn.qms.rest;

import java.util.List;

import com.fn.scada.dto.ScadaAssetsData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorLstScadaResponse extends BaseResponse{
	List<ScadaAssetsData> data;
}
