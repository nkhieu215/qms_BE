package com.fn.qms.rest;

import com.fn.scada.dto.ScadaAssetsData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScadaResponse extends BaseResponse{
	List<ScadaAssetsData> data;
}
