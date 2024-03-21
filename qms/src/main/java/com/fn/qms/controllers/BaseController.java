package com.fn.qms.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import javax.validation.ConstraintViolation;

import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.rest.BaseRequest;
import com.fn.qms.utils.AppLog;

@RestController
public class BaseController {


	@Autowired
	Validator validator;
	

	@Autowired
	HttpServletRequest httpRequest;

	public Logger logger = LogManager.getLogger(this.getClass());

	public Request setBase(Request request, BaseRequest param) {
		request.setUrlPath(httpRequest.getRequestURI());
		request.setRequestContent(param.toString());
		request.setIpAddress(httpRequest.getRemoteAddr());
		String userAgent = httpRequest.getHeader("User-Agent") == null ? "" : httpRequest.getHeader("User-Agent");
		request.setIpServer(httpRequest.getLocalAddr());
		AppLog.info(request.getRequestId());
		AppLog.info("Agent: " + userAgent);
		return request;
	}

	public Result validateInput(BaseRequest request) {
		Result result = Result.OK;
		// validation
 		List<String> validationMessages = this.validateRequest(validator.validate(request));
		if (validationMessages.size() > 0) {
			result = new SimpleResult(validationMessages.toString(), false, ResponseCode.INVALID_INPUT.getErrorCode());
		}
		return result;
	}
	
	public List<String> validateRequest(Set<ConstraintViolation<Object>> violations) {
        List<String> result = new ArrayList<String>();
        if (violations.size() > 0) {
            for (ConstraintViolation<Object> violation : violations) {
                result.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
        }
        return result;
    }
	
	
	public Result validate(BaseRequest request) {
        Result result = Result.OK;
       
        if (result.isOk()) {
            result = validateInput(request);
        }
        
        return result;
    }
}
