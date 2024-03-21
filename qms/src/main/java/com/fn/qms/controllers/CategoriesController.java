package com.fn.qms.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.rest.CommonResponse;
import com.fn.qms.rest.ErrorListRequest;
import com.fn.qms.rest.ErrorListResponse;
import com.fn.qms.rest.OitmRequest;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.CommonServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/categories")
public class CategoriesController extends BaseController{

	@Autowired
	private ApplicationContext context;
	
	@PostMapping("/crud-error-code")
	public ErrorListResponse crud(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ErrorListRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setErrorListRequest(param);
		
		ErrorListResponse response = new ErrorListResponse();
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

    		CommonServiceBase service = new CommonServiceBase();    		
    		response = service.crudError(request, user, context);
        }		
		return response;
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        