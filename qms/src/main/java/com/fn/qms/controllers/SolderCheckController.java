package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.dto.*;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.FixErrorServiceBase;
import com.fn.qms.services.SolderCheckService;
import com.fn.qms.services.TinCheckService;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/solder-error")
public class SolderCheckController extends BaseController {
	@Autowired
	SolderCheckService solderCheckService;

	@PostMapping("/create")
	public SolderCheckResponse solderCheckCreate(Authentication authen, HttpServletRequest requestClient,
											  @Valid @RequestBody SolderRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		SolderCheckResponse response  =  solderCheckService.solderCheckCreateUpdate(param);

		return response;
	}


	@DeleteMapping("/remove/{id}")
	public SolderCheckResponse remove(Authentication authen, HttpServletRequest requestClient,
										 @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   solderCheckService.removeByType(id);
	}

	@DeleteMapping("/remove-eror/{id}")
	public SolderCheckResponse removeError(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   solderCheckService.removeError(id);
	}

	@PostMapping("/add-error")
	public SolderCheckResponse addError(Authentication authen, HttpServletRequest requestClient,  @RequestBody SolderErrorRequest param) {
		SolderCheckResponse response = solderCheckService.addError(param);
		return response;
	}


	@PostMapping("/detail-solder/{id}")
	public SolderCheckResponse detailCheckSolder(Authentication authen, HttpServletRequest requestClient, @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		return   solderCheckService.detail(id);
	}
}
