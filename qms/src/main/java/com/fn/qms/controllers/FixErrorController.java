package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.dto.KeyValueDTO;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.FixErrorServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/fix-error")
public class FixErrorController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	FixErrorServiceBase fixErrorServiceBase;

	@PostMapping("/create")
	public BaseResponse crud(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody PqcFixErrRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setBaseRequest(param);
		BaseResponse response = new BaseResponse();

		Result result = null;
        result = validate(param);
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
    		request = setBase(request, param);
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

    		response = fixErrorServiceBase.createUpdate(request, user, context);
        }
		return response;
	}
	

	@PostMapping("/remove/{id}")
	public BaseResponse crudParam(Authentication authen, HttpServletRequest requestClient,
								  @PathVariable("id")  Long id,@Valid @RequestBody PqcFixErrRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + id);
		Request request = new Request();
		request.setId(id);
		param.setType("DELETE");
		request.setBaseRequest(param);
		BaseResponse response = new BaseResponse();

		Result result = null;
		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = fixErrorServiceBase.remove(request, user, context);
		}
		return response;
	}
}
