package com.fn.qms.command;

import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.repository.DAO.SapDBDAO;
import com.fn.qms.rest.SapRequest;
import com.fn.qms.rest.SapResponse;
import com.fn.qms.utils.AppLog;
import com.fn.sap.models.Coitt;

public class SapAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();
		
		SapRequest sapRequest = request.getSapRequest();
		
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		
		SapResponse res = new SapResponse();		
		SapDBDAO sapDao= ctx.getBean(SapDBDAO.class);				
		
		List<Coitt> lstCoitt = sapDao.getBomVersionByProductCode(sapRequest.getProCode(), sapRequest.getVersion());		
		
		if(lstCoitt != null && !lstCoitt.isEmpty()) {
			res.setCoitt(lstCoitt.get(0));
		}
		
		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
