package com.fn.qms.controllers;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.rest.*;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.SapServiceBase;
import com.fn.qms.services.DashboardService;
import com.fn.qms.services.SapService;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {
	@Autowired
	DashboardService dashboardService;

	@PostMapping("/home")
	public DashboardResponse getWaitApproveSap(Authentication authen, HttpServletRequest requestClient,  @Valid @RequestBody ProductionStepRequest param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());

		DashboardResponse response = dashboardService.getDashboardPqcIqc(param);
		return  response;

	}
	@PostMapping("/chart")
	public DashboardResponse getChart(Authentication authen, HttpServletRequest requestClient,  @Valid @RequestBody ProductionStepRequest param) {
		AppLog.info("test ting" + requestClient.getRequestURI() + "-" + param.toString());

		DashboardResponse response = dashboardService.getChart(param);
		return  response;

	}
	@PostMapping("/home-default") // * Lấy danh sách dashBoard
	public DashboardResponse getSumOfErrors(@RequestBody DashboardRequest dashboardRequest, HttpServletRequest requestClient){
		AppLog.info(requestClient.getRequestURI());
		DashboardResponse response;
		response = dashboardService.getSumOfErrors(dashboardRequest);
		return response;
	}
}
