package com.fn.qms.controllers;

import com.fn.qms.rest.*;
import com.fn.qms.services.AssemblesCheckService;
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
@RequestMapping("/assembles")
public class AssemblesCheckController extends BaseController {
	@Autowired
	AssemblesCheckService assemblesCheckService;

	@PostMapping("/create")
	public AssemblesCheckResponse solderCheckCreate(Authentication authen, HttpServletRequest requestClient,
												@Valid @RequestBody AssemblesRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		AssemblesCheckResponse response  =  assemblesCheckService.checkCreateUpdate(param);

		return response;
	}


	@DeleteMapping("/remove/{id}")
	public AssemblesCheckResponse remove(Authentication authen, HttpServletRequest requestClient,
										 @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   assemblesCheckService.removeByType(id);
	}

	@DeleteMapping("/remove-eror/{id}")
	public AssemblesCheckResponse removeError(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   assemblesCheckService.removeError(id);
	}

	@PostMapping("/add-error")
	public AssemblesCheckResponse addError(Authentication authen, HttpServletRequest requestClient,  @RequestBody AssemblesErrorRequest param) {
		AssemblesCheckResponse response = assemblesCheckService.addError(param);
		return response;
	}


	@PostMapping("/detail-assembles/{id}")
	public AssemblesCheckResponse detailCheckSolder(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   assemblesCheckService.detail(id);
	}
}
