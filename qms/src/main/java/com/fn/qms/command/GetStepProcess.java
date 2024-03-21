package com.fn.qms.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.dto.StepCheckDTO;
import com.fn.qms.dto.StepProcessDTO;
import com.fn.qms.models.StepProcess;
import com.fn.qms.repository.DAO.EmployeeDAO;
import com.fn.qms.repository.StepProcessRepository;
import com.fn.qms.rest.EmployeeResponse;
import com.fn.qms.rest.StepProcessResponse;
import com.fn.qms.utils.AppLog;
import com.fn.rd.models.Employee;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GetStepProcess implements Command {

	@Autowired
	StepProcessRepository stepProcessRepository;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();		
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		StepProcessResponse rest = new StepProcessResponse();
		List<StepProcess> lstProcess =	stepProcessRepository.findAll();
		if(lstProcess != null){
			List<StepProcessDTO> lstrest = Arrays.asList(objectMapper.convertValue(lstProcess,StepProcessDTO[].class));
			rest.setLstStep(lstrest);
		}
		response.setObj(rest);

		context.setResult(result);
		return !result.isOk();
	}

}
