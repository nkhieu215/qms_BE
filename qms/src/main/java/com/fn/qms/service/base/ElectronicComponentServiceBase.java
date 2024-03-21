package com.fn.qms.service.base;

import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.rest.service.ElectronicComponentApproveService;
import com.fn.qms.rest.service.ElectronicComponentSearchService;
import com.fn.qms.rest.service.ElectronicComponentService;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class ElectronicComponentServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public ElectronicComponentServiceBase() {
		ctx = new ProcessContext();
		Response response = new Response();
		ctx.setResponse(response);
	}
	
	/**
	 * tim kiem lkdt
	 * @param request
	 * @param user
	 * @param context
	 * @return
	 */
	public ElectronicComponentResponse searchElectronicComponent(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);		
		ElectronicComponentSearchService service = new ElectronicComponentSearchService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();		
		ElectronicComponentResponse resp = new ElectronicComponentResponse();
		resp.setResult(result);
		return resp;
	}

	public ElectronicComponentResponse crud(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);		
		ElectronicComponentService service = new ElectronicComponentService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();		
		Response response = ctx.getResponse();
		ElectronicComponentResponse resp = new ElectronicComponentResponse();
		if(result.isOk()) {
			resp = (ElectronicComponentResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}
	
	public ElectronicComponentResponse approve(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);		
		ElectronicComponentApproveService service = new ElectronicComponentApproveService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();		
		ElectronicComponentResponse resp = new ElectronicComponentResponse();
		resp.setResult(result);
		return resp;
	}

}
