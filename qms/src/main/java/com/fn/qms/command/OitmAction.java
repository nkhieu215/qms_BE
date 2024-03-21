package com.fn.qms.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.utils.AppLog;

public class OitmAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		OitmResponse res = new OitmResponse();

		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
