package com.fn.qms.controllers;

import com.fn.qms.dto.TinCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.repository.PqcInterchangeabilityCheckRepository;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.InterchangeabilityRequest;
import com.fn.qms.rest.InterchangeabilityResponse;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.services.InterchangeabilityService;
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
@RequestMapping("/pqc-interchangeability-check")
public class InterchangeabilityController extends BaseController{

	@Autowired
	InterchangeabilityService interchangeabilityService;
	@DeleteMapping("/remove/{id}")
	public BaseResponse remove(Authentication authen, HttpServletRequest requestClient,
							   @PathVariable("id")  Long id) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		BaseResponse response =  interchangeabilityService.removeById(id);
		return response;
	}
	
	@PostMapping("/create")
	public BaseResponse create(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody InterchangeabilityRequest param) {
		BaseResponse response =  interchangeabilityService.createUpdate(param);
		return response;
	}
}
