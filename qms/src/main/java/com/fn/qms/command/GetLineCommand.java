package com.fn.qms.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.dto.SettingMachineDTO;
import com.fn.qms.models.SettingLine;
import com.fn.qms.models.SettingMachine;
import com.fn.qms.repository.SettingLineRepository;
import com.fn.qms.repository.SettingMachineRepository;
import com.fn.qms.rest.LineResponse;
import com.fn.qms.rest.MachineResponse;
import com.fn.qms.utils.AppLog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@Service
public class GetLineCommand implements Command {

	@Autowired
	SettingLineRepository settingLineRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();		
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		LineResponse rest = new LineResponse();
		List<SettingLine> lines =	settingLineRepository.findAll();
		if(lines != null){

			Type listType = new TypeToken<List<SettingLineDTO>>(){}.getType();
			List<SettingLineDTO> lstrest = modelMapper.map(lines,listType);
			rest.setLstLine(lstrest);
		}
		response.setObj(rest);

		context.setResult(result);
		return !result.isOk();
	}

}
