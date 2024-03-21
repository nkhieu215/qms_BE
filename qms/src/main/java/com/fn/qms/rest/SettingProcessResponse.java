package com.fn.qms.rest;

import com.fn.qms.dto.SettingProcessDTO;
import com.fn.qms.dto.StepStatusDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettingProcessResponse extends BaseResponse{

	private List<SettingProcessDTO> lstSettingProcess;
}
