package com.fn.qms.rest;

import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.dto.SolderCheckDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MountCheckResponse extends BaseResponse{

	public List<MountCheckDTO> lstCheck;
	public Long idCheck;
	public MountCheckDTO detail;

}
