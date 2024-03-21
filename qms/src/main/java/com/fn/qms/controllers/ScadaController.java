package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.Request;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.ScadaServiceBase;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.scada.service.ScadaService;
import com.fn.qms.utils.AppLog;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/pqc-scada")
public class ScadaController extends BaseController{
	@Autowired
	ScadaServiceBase scadaServiceBase;

	@Autowired
	ScadaService scadaService;

	@Autowired
	private ApplicationContext context;

	@GetMapping("/machine-list")
	public MachineResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient) {	
		
		MachineResponse response = new MachineResponse();		
		response  =  scadaService.getMachine();		
		return response;
	}
	
	@GetMapping("/get-error-lst-scada/{sapcode}/{step}")
	public ErrorMachineResponse getErrorScada(Authentication authen, HttpServletRequest requestClient, @PathVariable("sapcode") String sapCode , @PathVariable("step") String step ) {	
		
		ErrorMachineResponse response = new ErrorMachineResponse();		
		response  =  scadaService.getErrorByStep(sapCode, step);		
		return response;
	}


	@GetMapping("/get-machine-by-wo-scada/{woId}/{type}")
	public ErrorMachineResponse getMachineByStep(Authentication authen, HttpServletRequest requestClient, @PathVariable("woId") Long woId , @PathVariable("type") String type
			) {
		Request request = new Request();
		ScadaRequest param = new ScadaRequest();
		param.setType(type);
		param.setId(woId);
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		request.setBaseRequest(param);
		ErrorMachineResponse response = new ErrorMachineResponse();

		Validator.Result result = null;

		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = scadaServiceBase.getMachineByWo(request, user, context);
		}
		return response;
	}
	
	
}
