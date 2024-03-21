package com.fn.qms.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import com.fn.qms.services.WoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.models.PqcBomWorkorder;
import com.fn.qms.rest.BaseRequest;
import com.fn.qms.rest.OitmRequest;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.rest.ProductionStepResponse;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.rest.ProfileResponse;
import com.fn.qms.rest.UserSettingResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.SapServiceBase;
import com.fn.qms.service.base.ProductionServiceBase;
import com.fn.qms.service.base.SettingServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/production")
public class ProductionController extends BaseController{
	
	@Autowired
	private ApplicationContext context;

	@Autowired
	WoService woService;
	
	@PostMapping("/get-order-planing-list")
	public ProductionStepResponse getOrderPlanningList(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ProductionStepRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setPlanningRequest(param);
		
		ProductionStepResponse response = new ProductionStepResponse();
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
    		
    		ProductionServiceBase service = new ProductionServiceBase();    		
    		response = service.getOrderPlanningList(request, user, context);
        }		
		return response;
	}
	
	
	@PostMapping("/crud")
	public ProductionStepResponse crud(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ProductionStepRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setPlanningRequest(param);
		
		ProductionStepResponse response = new ProductionStepResponse();
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
    		
    		ProductionServiceBase service = new ProductionServiceBase();    		
    		response = service.crud(request, user, context);
        }		
		return response;
	}

	@PostMapping("/check-step-production")
	public PqcWorkOrderResponse checkStepProduction(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ProductionStepRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setPlanningRequest(param);
		
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
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
    		
    		ProductionServiceBase service = new ProductionServiceBase();    		
    		response = service.getLstWorkOrderStep(request, user, context);
        }		
		return response;
	}
	
	
//
//	@PostMapping("/check-step")
//	public PqcWorkOrderResponse checkStep(Authentication authen, HttpServletRequest requestClient,
//			 @RequestBody ProductionStepRequest param) {
//
//		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
//		Request request = new Request();
//		request.setPlanningRequest(param);
//
//		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
//		Result result = null;
//        result = validate(param); //param validation
//        if (!result.isOk()) {
//        	response.setResult(result);
//        } else {
//        	// setcommon
//    		request = setBase(request, param);
//    		Principal principal = requestClient.getUserPrincipal();
//    		request.setPartnerId(principal.getName());
//
//    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
//    		ProductionServiceBase service = new ProductionServiceBase();
//    		response = service.getLstWorkOrderStep(request, user, context);
//        }
//		return response;
//	}


	@PostMapping("/check-step")
	public PqcWorkOrderResponse checkStepV2(Authentication authen, HttpServletRequest requestClient,  @RequestBody ProductionStepRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
		Result result = null;
		result = validate(param); //param validation
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
			response = woService.getLstCheckStep(param, user.getUsername());
		}
		return response;
	}

	@PostMapping("/cancel-process-check-wo")
	public PqcWorkOrderResponse cancelProcessCheckWo(Authentication authen, HttpServletRequest requestClient,  @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
		Result result = null;
		result = validate(param); //param validation
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
			woService.cancelProcessCheckWo(param.getId(), user.getUsername());
		}
		return response;
	}

	@PostMapping("/get-status-wo-step-user")
	public PqcWorkOrderResponse getStatusWoStepUser(Authentication authen, HttpServletRequest requestClient,  @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
		Result result = null;
		result = validate(param); //param validation
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
			response = woService.getStatusWoStepUser(param, user.getUsername());
		}
		return response;
	}
	
	@PostMapping("/productions-wo")
	public PqcWorkOrderResponse productionsWo(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ProductionStepRequest param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setPlanningRequest(param);
		
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
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
    		
    		ProductionServiceBase service = new ProductionServiceBase();    		
    		response = service.getLstWorkOrderStep(request, user, context);
        }		
		return response;
	}


	
	
	
}
