package com.fn.qms.command;

import java.util.List;

import com.fn.qms.utils.Utils;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Response;
import com.fn.qms.repository.DAO.UserService;
import com.fn.qms.rest.UserSettingResponse;
import com.fn.qms.rest.bean.MenuRes;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;


public class GetSettingByUser implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();	
		Response response = context.getResponse();
		
		UserService userService = ctx.getBean(UserService.class);		
		
		UserDetailsImpl user= context.getUser();
		UserSettingResponse res = new UserSettingResponse();
		List<MenuRes> lst = userService.getAllMenu(user);
		res.setLstmenu(lst);
		response.setObj(res);
		
		context.setResult(result);
		return !result.isOk();
	}

}
