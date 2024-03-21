package com.fn.qms.command;

import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.models.PqcWorkOrderPlanning;
import com.fn.qms.repository.DAO.PlanningWoDAO;
import com.fn.qms.rest.PlanningRequest;
import com.fn.qms.rest.PlanningResponse;
import com.fn.qms.utils.AppLog;

public class PlanningWoAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		Request request = context.getRequest();
		
		PlanningRequest param = request.getPlanningWoRequest();
		List<PqcWorkOrderPlanning> data = param.getData();

		PlanningWoDAO dao = ctx.getBean(PlanningWoDAO.class);
		dao.saveList(data);
		
		PlanningResponse res = new PlanningResponse();

		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
