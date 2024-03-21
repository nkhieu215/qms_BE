package com.fn.qms.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.IqcElectronicComponent;
import com.fn.qms.repository.DAO.ElectronicComponentsDAO;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.utils.AppLog;

public class ElectronicComponentApprove implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		Request request = context.getRequest();
		ElectronicComponentRequest param = request.getElectronicComponentRequest();
		ElectronicComponentsDAO componentsDAO = ctx.getBean(ElectronicComponentsDAO.class);
		ElectronicComponentResponse res = new ElectronicComponentResponse();
		List<String> lstStatus = new ArrayList<String>();
		lstStatus.add(Constant.IQC_STATUS_WAIT_APPROVE);

		Page<IqcElectronicComponent> page = componentsDAO.getLstElectronicComponentsByPage(param.getPage(),
				param.getSize(), param.getName(), lstStatus, null, null, param.getType());

		res.setTotal(page.getTotalPages());
		
		context.setResult(result);
		return !result.isOk();
	}

}
