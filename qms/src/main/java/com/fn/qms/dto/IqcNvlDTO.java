package com.fn.qms.dto;

import com.fn.qms.dto.iqc.nvl.IqcElectronicComponentDTO;
import com.fn.qms.dto.iqc.nvl.IqcCheckNvlDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IqcNvlDTO {

	private String typeRequest;
	private IqcElectronicComponentDTO component;
	private List<IqcCheckNvlDTO> lstIqcNvl;

		
}
