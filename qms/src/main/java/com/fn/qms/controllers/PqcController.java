package com.fn.qms.controllers;

import com.fn.qms.dto.PqcQualityDTO;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PqcApproveRequest;
import com.fn.qms.rest.QcCheckRequest;
import com.fn.qms.rest.QcCheckResponse;
import com.fn.qms.services.PqcService;
import com.fn.qms.services.QcCheckService;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Validated
@RequestMapping("/pqc")
public class PqcController extends BaseController {
	@Autowired
	PqcService qcCheckService;

	@PostMapping("/approve")
	public BaseResponse createUpdate(Authentication authen, HttpServletRequest requestClient,
										   @RequestBody PqcApproveRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response  =  qcCheckService.approve(param);

		return response;
	}

}
