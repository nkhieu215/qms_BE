package com.fn.qms.controllers;

import com.fn.planing.rest.DnlNvlResponse;
import com.fn.qms.dto.IqcNvlDTO;
import com.fn.qms.dto.NvlCreateDTO;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.NvlResponse;
import com.fn.qms.services.IqcCheckNvlService;
import com.fn.qms.services.NVLService;
import com.fn.qms.services.StorageService;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/iqc-nvl")
public class IqcNvlController extends BaseController{
	@Autowired
	StorageService storageService;

	@Autowired
	IqcCheckNvlService nvlService;
	
	@PostMapping("/create")
	public BaseResponse createCheckNvl(Authentication authen, HttpServletRequest requestClient, @RequestBody IqcNvlDTO param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());		
		NvlResponse response  =  nvlService.createNvlCheck(param);
		return response;
	}
	


}
