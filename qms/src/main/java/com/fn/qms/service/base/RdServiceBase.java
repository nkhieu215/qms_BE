package com.fn.qms.service.base;

import com.fn.qms.rest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.EmployeeResponse;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import org.springframework.stereotype.Service;

@Service
public class RdServiceBase extends ServiceBase{
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	@Override
	public ProcessContext loadContext(Request request, UserDetailsImpl userDetails) {
		return super.loadContext(request, userDetails);
	}

	@Autowired
	GetStepProcessScadaService getStepProcessService;
	/**
	 * lay thong tin linh kien
	 * @param request
	 * @param user
	 * @return
	 */
	public EmployeeResponse crud(Request request, UserDetailsImpl user, ApplicationContext context) {
		ProcessContext ctx = loadContext(request, user);
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		EmployeeService service = new EmployeeService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		EmployeeResponse resp = new EmployeeResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (EmployeeResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}
	/**
	 * lay thong tin linh kien
	 * @param request
	 * @param user
	 * @return
	 */
	public EmployeeResponse getStepProcess(Request request, UserDetailsImpl user, ApplicationContext context) {
		ProcessContext ctx = loadContext(request, user);
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		try {
			getStepProcessService.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		EmployeeResponse resp = new EmployeeResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (EmployeeResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}

	/**
	 * tim kiem linh kien dien tu
	 * @param request
	 * @param user
	 * @param context
	 * @return
	 */
	public OitmResponse searchOitm(Request request, UserDetailsImpl user, ApplicationContext context) {
		ProcessContext ctx = loadContext(request, user);
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		SearchOitmService service = new SearchOitmService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		OitmResponse resp = new OitmResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (OitmResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}	
	
}
