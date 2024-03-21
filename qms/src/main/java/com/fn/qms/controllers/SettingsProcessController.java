package com.fn.qms.controllers;

import com.fn.qms.dto.AqlTemplateDTO;
import com.fn.qms.dto.SettingProcessDTO;
import com.fn.qms.rest.AqlTemplateResponse;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.SettingProcessResponse;
import com.fn.qms.services.AqlTemplateService;
import com.fn.qms.services.SettingProcessService;
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
@RequestMapping("/settings-process")
public class SettingsProcessController extends BaseController{
	
	@Autowired
	SettingProcessService settingProcessService;
	
	@PostMapping("/add")
	public BaseResponse addProcess(Authentication authen, HttpServletRequest requestClient,
									   @Valid @RequestBody SettingProcessDTO param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response =  settingProcessService.createEdit(param);
		return response;
	}

	@PostMapping("/get-list")
	public SettingProcessResponse getList(Authentication authen, HttpServletRequest requestClient,
										  @Valid @RequestBody SettingProcessDTO param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		SettingProcessResponse response =  settingProcessService.getList(param);
		return response;
	}

	
	@DeleteMapping("/remove/{id}")
	public BaseResponse remove(Authentication authen, HttpServletRequest requestClient,
			@PathVariable("id")  Long id) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		BaseResponse response =  settingProcessService.remove(id);
		return response;
	}
}
