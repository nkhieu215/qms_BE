package com.fn.qms.command;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.SettingMachineDTO;
import com.fn.qms.models.SettingMachine;
import com.fn.qms.repository.DAO.MachineDAO;
import com.fn.qms.rest.MachineRequest;
import com.fn.qms.rest.MachineResponse;
import com.fn.qms.utils.AppLog;
import com.fn.rd.models.Machine;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import java.util.List;


public class MachineAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Request request = context.getRequest();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		MachineResponse res = new MachineResponse();
		MachineDAO machineDao= ctx.getBean(MachineDAO.class);
		MachineRequest machineRequest = request.getMachineRequest();
		String type = machineRequest.getType();

		if(Constant.ACTION_ADD.equalsIgnoreCase(type)){
			machineDao.createUpdate(request.getMachineRequest().getDataRequest());
		}else{
			Page<SettingMachine> lst = machineDao.getListByPage(machineRequest.getPage(), machineRequest.getSize(),machineRequest);

			ModelMapper modelMapper = new ModelMapper();
			res.setTotal(lst.getTotalPages());

			List<SettingMachineDTO> entityToDto = modelMapper.map(lst.getContent(), new TypeToken<List<SettingMachineDTO>>() {}.getType());

			res.setLstMachine(entityToDto);
		}


		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
