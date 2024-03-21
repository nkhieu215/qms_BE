package com.fn.qms.service.base;

import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.PlanningResponse;
import com.fn.qms.rest.service.SAPService;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class PlanningServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public PlanningServiceBase() {
		ctx = new ProcessContext();
		Response response = new Response();
		ctx.setResponse(response);
	}

	/**
	 * lay thong tin linh kien
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	public PlanningResponse sendWo(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		SAPService service = new SAPService();
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		PlanningResponse resp = new PlanningResponse();
		if (result.isOk()) {
			Response response = ctx.getResponse();
			resp = (PlanningResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}

}
