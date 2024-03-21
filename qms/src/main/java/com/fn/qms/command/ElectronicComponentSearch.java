package com.fn.qms.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.repository.DAO.ExaminationDAO;
import com.fn.qms.rest.iqc.ExaminationRequest;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.utils.AppLog;

public class ElectronicComponentSearch implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		
		Request request =  context.getRequest();
		ExaminationRequest param = request.getExaminationRequest();
		String typeRequest = param.getTypeRequest();
		ExaminationDAO examinationService = ctx.getBean(ExaminationDAO.class);
		ExaminationResponse res =  new ExaminationResponse();
		if(Constant.ACTION_BROWS.equalsIgnoreCase(typeRequest)) {
//			int total = 0;
//			res.setLstExamination(examinationService.getLstExaminationByPage(param.getPage(), param.getSize(), param.getName(), total));			
//			res.setTotal(total);
		}		
		else if(Constant.ACTION_ADD.equalsIgnoreCase(typeRequest)) {
			examinationService.saveIqcExamination(param.getExamination(), param.getLstCriteriaLkdt(), param.getLsCriteriaNvl(), param.getLstParameter(), param.getLstCriteriaQualities());
		}
		
		
		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
