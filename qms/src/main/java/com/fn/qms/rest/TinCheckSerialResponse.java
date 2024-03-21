package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.SolderCheckDTO;
import com.fn.qms.dto.TinCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinCheckSerialResponse extends BaseResponse{

	public List<TinCheckSerialDTO> lstTinCheckSerial;
	public Long idCheck;

	public TinCheckDTO detail;

}
