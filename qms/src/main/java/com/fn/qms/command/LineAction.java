package com.fn.qms.command;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.models.SettingLine;
import com.fn.qms.repository.DAO.LineDAO;
import com.fn.qms.repository.DAO.SapDBDAO;
import com.fn.qms.rest.LineRequest;
import com.fn.qms.rest.LineResponse;
import com.fn.qms.rest.SapRequest;
import com.fn.qms.rest.SapResponse;
import com.fn.qms.utils.AppLog;
import com.fn.sap.models.Coitt;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import java.util.List;


public class LineAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		LineResponse res = new LineResponse();
		LineDAO lineDao= ctx.getBean(LineDAO.class);
		LineRequest line = request.getLineRequest();
		String type = line.getType();
		if(Constant.ACTION_ADD.equalsIgnoreCase(type)){
			lineDao.createUpdate(request.getLineRequest().getDataRequest());
		}else{
			Page<SettingLine> lst = lineDao.getListByPage(line.getPage(), line.getSize(),line);

			ModelMapper modelMapper = new ModelMapper();
			res.setTotal(lst.getTotalPages());

			List<SettingLineDTO> entityToDto = modelMapper.map(lst.getContent(), new TypeToken<List<SettingLineDTO>>() {}.getType());

			res.setLstLine(entityToDto);
		}


		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
