package com.fn.qms.controllers;

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
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PlanningRequest;
import com.fn.qms.rest.SapResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.SapServiceBase;
import com.fn.qms.utils.AppLog;

@RestController
@Validated
@RequestMapping("/planning-service")
public class PlanningController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@PostMapping("/send-wo")
	public BaseResponse getInfoByBomVersionAndProductCode(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody PlanningRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setPlanningWoRequest(param);
		
		SapResponse response = new SapResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		Principal principal = requestClient.getUserPrincipal();
    		request.setPartnerId(principal.getName());
    		UserDetailsImpl user = (UserDetailsImpl) authen.getPrincipal();
    		
    		SapServiceBase service = new SapServiceBase();    		
    		response = service.getInfoByBomVersionAndProductCode(request, user, context);
        }		
		return response;
	}
}
