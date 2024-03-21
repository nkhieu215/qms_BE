package com.fn.qms.service.base;

import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.UserSettingResponse;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.rest.service.UserSettingService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class SettingServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public SettingServiceBase() {
		ctx = new ProcessContext();
		Response response = new Response();
		ctx.setResponse(response);
	}

	/**
	 * lay thong tin setting cua user
	 * @param request
	 * @param user
	 * @return
	 */
	public UserSettingResponse getMenuSetting(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		UserSettingService service = new UserSettingService();		
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
		UserSettingResponse resp = new UserSettingResponse();
		if(result.isOk()) {
			resp = (UserSettingResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}


	

}
