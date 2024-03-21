package com.fn.qms.rest;

import com.fn.qms.dto.SolderCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SolderCheckResponse extends BaseResponse{

	public List<SolderCheckDTO> lstCheck;
	public Long idCheck;
	public SolderCheckDTO detail;

}
