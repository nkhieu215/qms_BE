package com.fn.qms.controllers;

import com.fn.qms.dto.AqlTemplateDTO;
import com.fn.qms.dto.TinCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.rest.AqlTemplateResponse;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.services.AqlTemplateService;
import com.fn.qms.services.TinCheckService;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/pqc-aql-template")
public class TemplateAQLController extends BaseController{
	
	@Autowired
	AqlTemplateService aqlTemplateService;
	
	@PostMapping("/add")
	public BaseResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient,
									   @Valid @RequestBody AqlTemplateDTO param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response =  aqlTemplateService.createEdit(param);
		return response;
	}

	@PostMapping("/get-list")
	public AqlTemplateResponse getList(Authentication authen, HttpServletRequest requestClient,
									   @Valid @RequestBody AqlTemplateDTO param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		AqlTemplateResponse response =  aqlTemplateService.getList(param);
		return response;
	}

	
	@DeleteMapping("/remove/{id}")
	public BaseResponse remove(Authentication authen, HttpServletRequest requestClient,
			@PathVariable("id")  Long id) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		BaseResponse response =  aqlTemplateService.remove(id);
		return response;
	}
}
