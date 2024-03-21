package com.fn.rd.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.controllers.BaseController;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.ErrorListRequest;
import com.fn.qms.rest.ErrorListResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.CommonServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import com.fn.rd.dto.ErrorDTO;
import com.fn.rd.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/error")
public class ErrorListController extends BaseController {

	@Autowired
	ErrorService errorService;

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

	@PostMapping("/create-update")
	public BaseResponse createUpdte(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody ErrorDTO param){
		return errorService.create(param);
	}


	@PostMapping("/find-by-id")
	public com.fn.rd.rest.ErrorListResponse getById(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody ErrorDTO param){
		return errorService.getById(param.getId());
	}

	@PostMapping("/remove-by-id")
	public BaseResponse removeById(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody ErrorDTO param){
		return errorService.removeById(param.getId());
	}


}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        