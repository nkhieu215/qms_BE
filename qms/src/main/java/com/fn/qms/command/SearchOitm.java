package com.fn.qms.command;

import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.repository.DAO.OitmDAO;
import com.fn.qms.rest.OitmResponse;
import com.fn.qms.rest.bean.OitmObj;
import com.fn.qms.utils.AppLog;

public class SearchOitm implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		String nameSearch = request.getParam1();
		OitmResponse res = new OitmResponse();
		OitmDAO oitmDao = ctx.getBean(OitmDAO.class);

		List<OitmObj> lstOitm = oitmDao.searchOitmByCode(nameSearch);
		res.setLstOitm(lstOitm);

		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
