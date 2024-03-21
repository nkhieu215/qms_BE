package com.fn.qms.rest;

import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.dto.MountCheckDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssemblesCheckResponse extends BaseResponse{

	public List<AssemblesSuccessCheckDTO> lstCheck;
	public Long idCheck;
	public AssemblesSuccessCheckDTO detail;

}
