package com.fn.qms.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fn.qms.services.ElectronicComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.rest.iqc.ExaminationRequest;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.ElectronicComponentServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

//@RolesAllowed({"admin_qms_test","approve_iqc"})

@RestController
@RequestMapping("/electronic-components")
public class ElectronicComponentsController extends BaseController{

	@Autowired
	private ApplicationContext context;

	@Autowired
	ElectronicComponentService electronicComponentService;
	

	@PostMapping("/crud")
	public BaseResponse crud(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ElectronicComponentRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setElectronicComponentRequest(param);
		ElectronicComponentResponse response = new ElectronicComponentResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		Principal principal = requestClient.getUserPrincipal();
    		request.setPartnerId(principal.getName());
			request.setIqcSearchParam(param.getParam());
    		
    		ElectronicComponentServiceBase service = new ElectronicComponentServiceBase();
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
    		response = service.crud(request, user, context);
        }
		
		return response;
	}

	@PostMapping("/create")
	public BaseResponse updateEdit(HttpServletRequest requestClient, @RequestBody ElectronicComponentRequest param){
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return electronicComponentService.createUpdate(param,user.getUsername());
	}
	@PostMapping("/create-param")
	public BaseResponse createParam(HttpServletRequest requestClient, @RequestBody ElectronicComponentRequest param){
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return electronicComponentService.createParamCheck(param,user.getUsername());
	}

	/**
	 * Xóa biên bản kiểm tra
	 * @param requestClient
	 * @param id
	 * @return
	 */
	@DeleteMapping("/remove/{id}")
	public BaseResponse removeCheck(HttpServletRequest requestClient,@PathVariable("id")  Long id){
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return electronicComponentService.removeCheck(id,user.getUsername());
	}


	/**
	 * Xóa các thông tin ktra trong biên bản
	 * @param requestClient
	 * @param id
	 * @param elecComId
	 * @param type
	 * @return
	 */
	@DeleteMapping("/remove-check-result/{id}/{elecComId}/{type}")
	public BaseResponse removeCheckResult(HttpServletRequest requestClient,@PathVariable("id")  Long id, @PathVariable("elecComId")  Long elecComId
			, @PathVariable("type")  String type){
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return electronicComponentService.removeCheckResult(id,elecComId,type);
	}



	@PreAuthorize("hasAnyAuthority('qms_admin','qms_approve_iqc')")
	@PostMapping("/lst-approve")
	public BaseResponse lstApprove(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ElectronicComponentRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setElectronicComponentRequest(param);
		ElectronicComponentResponse response = new ElectronicComponentResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		Principal principal = requestClient.getUserPrincipal();
    		request.setPartnerId(principal.getName());
    		
    		ElectronicComponentServiceBase service = new ElectronicComponentServiceBase();
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
    		response = service.crud(request, user, context);
        }
		
		return response;
	}

	@PreAuthorize("hasAnyAuthority('qms_admin','qms_approve_iqc')")
	@PostMapping("/approve")
	public BaseResponse approve(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody ExaminationRequest param) { 
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Request request = new Request();
		request.setExaminationRequest(param);
		ElectronicComponentResponse response = new ElectronicComponentResponse();
		Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
        	response.setResult(result);
        } else {
        	// setcommon
    		request = setBase(request, param);
    		Principal principal = requestClient.getUserPrincipal();
    		request.setPartnerId(principal.getName());
    		
    		ElectronicComponentServiceBase service = new ElectronicComponentServiceBase();
    		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
    		response = service.approve(request, user, context);
        }
		
		return response;
	}

	@GetMapping("/detail/{id}")
	public BaseResponse detailCheck(@PathVariable("id")  Long id){
		return electronicComponentService.getDetailElectronicComponent(id);
	}

	@PostMapping("/copy/{id}")
	public BaseResponse copyComponent(@PathVariable("id")  Long id){
		return electronicComponentService.copyElectronicComponent(id);
	}

	@PreAuthorize("hasAnyAuthority('qms_admin','qms_iqc')")
	@PostMapping("/find-list")
	public BaseResponse getListByUser(HttpServletRequest requestClient, @RequestBody ElectronicComponentRequest param){
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		return electronicComponentService.getListByUser(user.getUsername(), param);
	}
}
