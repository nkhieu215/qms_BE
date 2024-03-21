package com.fn.qms.controllers;

import com.fn.qms.rest.*;
import com.fn.qms.services.MountCheckService;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/mount")
public class MountCheckController extends BaseController {
	@Autowired
	MountCheckService mountCheckService;

	@PostMapping("/create")
	public MountCheckResponse solderCheckCreate(Authentication authen, HttpServletRequest requestClient,
												@Valid @RequestBody MountRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		MountCheckResponse response  =  mountCheckService.mountCheckCreateUpdate(param);

		return response;
	}


	@DeleteMapping("/remove/{id}")
	public MountCheckResponse remove(Authentication authen, HttpServletRequest requestClient,
										 @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   mountCheckService.removeByType(id);
	}

	@DeleteMapping("/remove-eror/{id}")
	public MountCheckResponse removeError(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   mountCheckService.removeError(id);
	}

	@PostMapping("/add-error")
	public MountCheckResponse addError(Authentication authen, HttpServletRequest requestClient,  @RequestBody MountErrorRequest param) {
		MountCheckResponse response = mountCheckService.addError(param);
		return response;
	}


	@PostMapping("/detail-mount/{id}")
	public MountCheckResponse detailCheckSolder(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   mountCheckService.detail(id);
	}
}
