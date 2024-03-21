package com.fn.qms.service.base;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.LineResponse;
import com.fn.qms.rest.MachineResponse;
import com.fn.qms.rest.service.LineService;
import com.fn.qms.rest.service.MachineService;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import org.springframework.context.ApplicationContext;

public class MachineServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public MachineServiceBase() {
		ctx = new ProcessContext();
		Response response = new Response();
		ctx.setResponse(response);
	}

	public MachineResponse createUpdate(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		MachineService service = new MachineService();
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		MachineResponse resp = new MachineResponse();
		if (result.isOk()) {
			Response response = ctx.getResponse();
			resp = (MachineResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}

    public MachineResponse getMachine(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		MachineService service = new MachineService();
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		MachineResponse resp = new MachineResponse();
		if (result.isOk()) {
			Response response = ctx.getResponse();
			resp = (MachineResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
    }
}
