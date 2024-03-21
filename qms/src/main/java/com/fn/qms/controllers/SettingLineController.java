package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.constant.Constant;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.LineServiceBase;
import com.fn.qms.service.base.ProductionServiceBase;
import com.fn.qms.service.base.SapServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/setting-line")
public class SettingLineController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@PostMapping("/create-update")
	public BaseResponse getInfoByBomVersionAndProductCode(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody LineRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		param.setType(Constant.ACTION_ADD);
		request.setLineRequest(param);

		LineResponse response = new LineResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
			request = setBase(request, param);
			Principal principal = requestClient.getUserPrincipal();
			request.setPartnerId(principal.getName());

			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			LineServiceBase service = new LineServiceBase();
    		response = service.createUpdate(request, user, context);
        }		
		return response;
	}

	@PostMapping("/index")
	public LineResponse checkStepProduction(Authentication authen, HttpServletRequest requestClient,
													@Valid @RequestBody LineRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		param.setType(Constant.ACTION_BROWS);
		request.setLineRequest(param);

		LineResponse response = new LineResponse();
		Result result = null;
		result = validate(param); //param validation
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			// setcommon
			request = setBase(request, param);
			Principal principal = requestClient.getUserPrincipal();
			request.setPartnerId(principal.getName());

			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			LineServiceBase service = new LineServiceBase();
			response = service.getLstLine(request, user, context);
		}
		return response;
	}
}
