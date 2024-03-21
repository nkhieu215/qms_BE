package com.fn.rd.controllers; 

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.controllers.BaseController;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.EmployeeRequest;
import com.fn.qms.rest.EmployeeResponse;
import com.fn.qms.rest.OitmRequest;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.RdServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

@RestController
@Validated
@RequestMapping("/rd-common")
public class RdController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	RdServiceBase rdServiceBase;

	@PostMapping("/error")
	public BaseResponse crud(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody EmployeeRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setParam1(param.getName());
		
		EmployeeResponse response = new EmployeeResponse();
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


			rdServiceBase.crud(request, user, context);
        }		
		return response;
	}

	@PostMapping("/get-step-process")
	public BaseResponse getStepProcess(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody EmployeeRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setParam1(param.getName());

		EmployeeResponse response = new EmployeeResponse();
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

			response = rdServiceBase.getStepProcess(request, user, context);
		}
		return response;
	}
	

	@PostMapping("/search-oitm")
	public BaseResponse searchOitm(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody OitmRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setParam1(param.getName());
		
		OitmResponse response = new OitmResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		Principal principal = requestClient.getUserPrincipal();
    		request.setPartnerId(principal.getName());
    		
    		request.setParam1(param.getCode());
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

    		response = rdServiceBase.searchOitm(request, user, context);
        }		
		return response;
	}
}
