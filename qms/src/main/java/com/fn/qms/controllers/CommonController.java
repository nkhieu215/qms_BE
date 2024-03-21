package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.dto.KeyValueDTO;
import com.fn.qms.repository.ApproveHisRepository;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.CommonServiceBase;
import com.fn.qms.service.base.ExaminationServiceBase;
import com.fn.qms.services.CommonService;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/common")
public class CommonController extends BaseController {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CommonServiceBase commonServiceBase;

	@Autowired
	CommonService commonService;



	@PostMapping("/error-list")
	public ErrorListResponse errorList(Authentication authen, HttpServletRequest requestClient,
								  @Valid @RequestBody ErrorListRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setBaseRequest(param);
		ErrorListResponse response = new ErrorListResponse();

		Result result = null;
        result = validate(param);
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
    		request = setBase(request, param);
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

    		response = commonServiceBase.errorList(request, user, context);
        }
		return response;
	}


	@PostMapping("/search-error-scada")
	public ErrorListResponse searchErrorScada(Authentication authen, HttpServletRequest requestClient,
									   @Valid @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		param.setTypeRequest("SEARCH");
		request.setBaseRequest(param);
		ErrorListResponse response = new ErrorListResponse();

		Result result = null;
		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = commonServiceBase.searchErrorScada(request, user, context);
		}
		return response;
	}


	@PostMapping("/step-process-list")
	public StepProcessResponse stepProcessList(Authentication authen, HttpServletRequest requestClient,
									   @Valid @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setBaseRequest(param);
		StepProcessResponse response = new StepProcessResponse();

		Result result = null;
		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = commonServiceBase.getStepProcess(request, user, context);
		}
		return response;
	}


	@PostMapping("/machine-list")
	public MachineResponse getMachineList(Authentication authen, HttpServletRequest requestClient,
											   @Valid @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setBaseRequest(param);
		MachineResponse response = new MachineResponse();

		Result result = null;
		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = commonServiceBase.getMachineList(request, user, context);
		}
		return response;
	}

	@PostMapping("/line")
	public LineResponse getLineList(Authentication authen, HttpServletRequest requestClient,
										  @Valid @RequestBody BaseRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setBaseRequest(param);
		LineResponse response = new LineResponse();

		Result result = null;
		result = validate(param);
		if (!result.isOk()) {
			response.setResult(result);
		} else {
			request = setBase(request, param);
			UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);

			response = commonServiceBase.getLineList(request, user, context);
		}
		return response;
	}

	@PostMapping("/success-step")
	public BaseResponse successStep(Authentication authen, HttpServletRequest requestClient,
									@Valid @RequestBody BaseRequest param) {
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return commonService.updateStepStatus(param.getId(),param.getStep(), user.getUsername());
	}


	@PostMapping("/status-user-step")
	public StepStatusResponse statusUserStep(Authentication authen, HttpServletRequest requestClient,
									@Valid @RequestBody BaseRequest param) {
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return commonService.statusUserStep(param.getId());
	}


	@PreAuthorize("hasAnyAuthority('qms_admin','qms_approve_iqc','qms_approve_pqc')")
	@PostMapping("/approve")
	public BaseResponse approveCheck(Authentication authen, HttpServletRequest requestClient,
									@RequestBody ApproveCheckRequest param) {
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return commonService.approveCheck(param, user.getUsername());
	}

	@GetMapping("/get-setting-process")
	public SettingProcessResponse settingProcess(Authentication authen, HttpServletRequest requestClient) {
		return commonService.settingProcess();
	}


}
