package com.fn.qms.rest.iqc;

import java.util.List;

import com.fn.qms.dto.iqc.nvl.IqcElectronicComponentDTO;
import com.fn.qms.models.IqcElectronicComponent;

import com.fn.qms.rest.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicComponentResponse extends BaseResponse {

	List<IqcElectronicComponentDTO> lst;
	IqcElectronicComponentDTO component;
}
