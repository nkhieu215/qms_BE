package com.fn.qms.service.base;

import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.rest.service.ExaminationParamService;
import com.fn.qms.rest.service.ExaminationService;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class ExaminationServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public ExaminationServiceBase() {
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
	public ExaminationResponse crudExamination(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		ExaminationService service = new ExaminationService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		ExaminationResponse resp = new ExaminationResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (ExaminationResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}
	
	/**
	 * lay thong tin setting cua user
	 * @param request
	 * @param user
	 * @return
	 */
	public ExaminationResponse crudExaminationParam(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		ExaminationParamService service = new ExaminationParamService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		ExaminationResponse resp = new ExaminationResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (ExaminationResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}
	
}
