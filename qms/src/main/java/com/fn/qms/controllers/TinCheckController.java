package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fn.qms.rest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.dto.TinCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.services.TinCheckService;
import com.fn.qms.utils.AppLog;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/pqc-tin-check")
public class TinCheckController extends BaseController{
	
	@Autowired
	TinCheckService tinCheckService;
	
	@PostMapping("/check-serial-tin")
	public TinCheckSerialResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody TinCheckSerialDTO param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());		
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		
		response  =  tinCheckService.pqcTinCheckSerial(param);
		
		return response;
	}
	
	
	@GetMapping("/check-serial-by-workorder/{id}")
	public TinCheckSerialResponse getCheckSerialByWorkOrder(Authentication authen, HttpServletRequest requestClient,
			@PathVariable("id")  Long id) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());		
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		
		response  =  tinCheckService.lstTinCheckByWorkOrder(id);
		
		return response;
	}
	
	@DeleteMapping("/remove/{id}/{type}")
	public TinCheckSerialResponse remove(Authentication authen, HttpServletRequest requestClient,
			@PathVariable("id")  Long id, @PathVariable("type")  String type) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());		
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		
		response  =  tinCheckService.removeByType(id, type);
		
		return response;
	}
	
	@PostMapping("/add-new-tin-check")
	public TinCheckSerialResponse addNewTinCheck(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody TinCheckDTO param) {
		
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		response  =  tinCheckService.addNewTinCheck(param);
		return response;
	}


	@DeleteMapping("/remove-eror/{id}")
	public TinCheckSerialResponse removeError(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   tinCheckService.removeError(id);
	}

	@PostMapping("/add-error")
	public TinCheckSerialResponse addError(Authentication authen, HttpServletRequest requestClient,  @RequestBody TinErrorRequest param) {
		TinCheckSerialResponse response = tinCheckService.addError(param);
		return response;
	}

	@PostMapping("/detail-check/{id}")
	public TinCheckSerialResponse detailCheckSolder(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   tinCheckService.detail(id);
	}
}
