package com.fn.qms.rest;

import com.fn.qms.dto.TinCheckSerialDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UploadFileResponse extends BaseResponse{

	public List<String> lstFile;
}
