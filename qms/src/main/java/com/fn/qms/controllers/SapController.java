package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fn.qms.rest.*;
import com.fn.qms.services.SapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.SapServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

@RestController
@Validated
@RequestMapping("/sap-db")
public class SapController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	SapService sapService;

	@PostMapping("/get-info-by-bom-product")
	public BaseResponse getInfoByBomVersionAndProductCode(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody SapRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setSapRequest(param);
		
		SapResponse response = new SapResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		
    		
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
    		
    		SapServiceBase service = new SapServiceBase();    		
    		response = service.getInfoByBomVersionAndProductCode(request, user, context);
        }		
		return response;
	}

	@GetMapping("/get-common-approve-sap")
	public SapCommonResponse getCommonApproveSap(Authentication authen, HttpServletRequest requestClient) {
		AppLog.info(requestClient.getRequestURI());
		SapCommonResponse response = sapService.getCommonApproveSap();
		return  response;

	}

	@PostMapping("/get-wait-approve-sap")
	public PqcWorkOrderResponse getWaitApproveSap(Authentication authen, HttpServletRequest requestClient,  @Valid @RequestBody ProductionStepRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());

		PqcWorkOrderResponse response = sapService.getWaitApproveSap(param.getPage(), param.getSize(), param.getName(),param.getCode(), param.getLot(), param.getStartDate(), param.getEndDate(), param.getSap(), param.getWoCode(), param.getGroupName(), param.getBranchName());
		return  response;

	}
	@GetMapping("/get-color")
	public SapCommonResponse getColor(Authentication authen, HttpServletRequest requestClient) {
		AppLog.info(requestClient.getRequestURI());

		SapCommonResponse response = sapService.getColor();
		return  response;

	}

	@PostMapping("/get-ocrd")
	public SapCommonResponse getOcrd(Authentication authen, HttpServletRequest requestClient,@RequestBody BaseRequest request) {
		AppLog.info(requestClient.getRequestURI());
		SapCommonResponse response = sapService.getOcrd(request.getName());
		return  response;
	}
}
