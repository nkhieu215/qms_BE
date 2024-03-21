package com.fn.qms.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.repository.DAO.ExaminationDAO;
import com.fn.qms.rest.ExaminationParamRequest;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.utils.AppLog;

public class ExaminationParam implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		Request request = context.getRequest();
		ExaminationParamRequest param = request.getExminationParam();
		String typeRequest = param.getTypeRequest();
		ExaminationDAO examinationService = ctx.getBean(ExaminationDAO.class);
		ExaminationResponse res = new ExaminationResponse();

		examinationService.actionNVL(param.getCriteriaNvl(), typeRequest);
		examinationService.actionLKDT(param.getCriteriaLkdt(), typeRequest);
		examinationService.actionParam(param.getParameter(), typeRequest);
		examinationService.actionTCKT(param.getQualities(), typeRequest);

		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
