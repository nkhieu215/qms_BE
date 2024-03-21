package com.fn.qms.command;

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
import com.fn.qms.repository.DAO.ErrorListDAO;
import com.fn.qms.rest.ErrorListRequest;
import com.fn.qms.rest.ErrorListResponse;
import com.fn.qms.utils.AppLog;
import com.fn.rd.models.ErrorList;

public class ErrorAction implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();
		
		Request request = context.getRequest();
		ErrorListRequest param = request.getErrorListRequest();
		String typeRequest = param.getTypeRequest();
		
		ErrorListDAO errorListService = ctx.getBean(ErrorListDAO.class);
		ErrorListResponse res = new ErrorListResponse();

		switch (typeRequest) {
		case Constant.ACTION_BROWS_ALL:			
			List<ErrorList> lst = errorListService.getAllErrorType();
			res.setLstError(lst);
			break;
		case Constant.ACTION_BROWS:
			Page<ErrorList> pageContent = errorListService.getLstErrorListByPage(param.getPage(),
					param.getSize(), param.getName());

			res.setLstError(pageContent.getContent());
			res.setTotal(pageContent.getTotalPages());
			break;

		case Constant.ACTION_SHOW:
			ErrorList detail = errorListService.getErrorDetail(param.getId());
			res.setError(detail);
			break;

		case Constant.ACTION_ADD:
			errorListService.saveError(param.getErrorBean());
			break;

		case Constant.ACTION_EDIT:

			errorListService.updateError(param.getErrorBean());
			
			
			break;
			
			
		case Constant.ACTION_DELETE:
			errorListService.deleteError(param.getId());
			break;

		default:
			break;
		}
		
		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
