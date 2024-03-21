package com.fn.qms.command;

import java.util.ArrayList;
import java.util.List;

import com.fn.qms.security.services.UserDetailsImpl;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.IqcElectronicComponent;
import com.fn.qms.repository.DAO.ElectronicComponentsDAO;
import com.fn.qms.rest.iqc.ElectronicComponentRequest;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

public class ElectronicComponentCRUD implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
		ProcessContext context = (ProcessContext) cntxt;
		Response response = context.getResponse();
		Validator.Result result = Validator.Result.OK;
		ApplicationContext ctx = context.getContext();

		Request request = context.getRequest();
		ElectronicComponentRequest param = request.getElectronicComponentRequest();
		String typeRequest = param.getTypeRequest();
		
		ElectronicComponentsDAO componentsDAO = ctx.getBean(ElectronicComponentsDAO.class);
		ElectronicComponentResponse res = new ElectronicComponentResponse();

		UserDetailsImpl user = context.getUser();
		String userId = user.getUsername();

		switch (typeRequest) {
		case Constant.ACTION_BROWS:
			
			List<String> lstStatus = new ArrayList<String>();
			if(!Utils.isNull(param.getStatus()) ) {
				lstStatus.add(param.getStatus());
			}else {
				lstStatus.add(Constant.IQC_STATUS_DRAFF);
				lstStatus.add(Constant.IQC_STATUS_APPROVE);
				lstStatus.add(Constant.IQC_STATUS_WAIT_APPROVE);
			}
			
			Page<IqcElectronicComponent> page = componentsDAO.searcheElectronic(param.getPage(), param.getSize(), request.getIqcSearchParam(), userId, param.getType());
			
//			res.setLst(page.getContent());
			res.setTotal(page.getTotalPages());
			break;

		case Constant.ACTION_ADD:
//			param.getComponent().setCreateBy(userId);
			IqcElectronicComponent componentElectronicComponent =  componentsDAO.saveElectronicComponent(param);
//			res.setComponent(componentElectronicComponent);
			break;

		case Constant.ACTION_EDIT:
			IqcElectronicComponent componentEdit = componentsDAO.getById(param.getComponent().getId());			
			if(componentEdit != null && Constant.IQC_STATUS_DRAFF.equalsIgnoreCase(componentEdit.getStatus()) ) {
				componentsDAO.saveElectronicComponent(param);
			}else {
				result = new SimpleResult(ResponseCode.STATUS_INVALID.getDesc(), CONTINUE_PROCESSING, ResponseCode.STATUS_INVALID.getErrorCode());
			}
			
			break;

		case Constant.ACTION_DELETE:
			componentsDAO.delete(param.getId());
			break;
			
		case Constant.ACTION_APPROVE:
//			param.getComponent().setAproveBy(userId);
			
			IqcElectronicComponent component = componentsDAO.getById(param.getComponent().getId());
			if(component != null && Constant.IQC_STATUS_WAIT_APPROVE.equalsIgnoreCase(component.getStatus()) ) {
//				componentsDAO.approveElectronicComponent(param.getComponent());
			}else {
				result = new SimpleResult(ResponseCode.STATUS_APPROVE_INVALID.getDesc()	, CONTINUE_PROCESSING, ResponseCode.STATUS_APPROVE_INVALID.getErrorCode());
			}
			
			
			break;

		case Constant.LST_APPROVE:
			List<String> lstStatusWaitApprove = new ArrayList<String>();
			lstStatusWaitApprove.add(Constant.IQC_STATUS_WAIT_APPROVE);
					
			Page<IqcElectronicComponent> pageLstApprove = componentsDAO.getLstElectronicComponentsByPage(param.getPage(), param.getSize(), param.getName(), lstStatusWaitApprove, null, null, null);
//			res.setLst(pageLstApprove.getContent());
			res.setTotal(pageLstApprove.getTotalPages());
			break;
		default:
			break;
		}

		response.setObj(res);
		context.setResult(result);
		return !result.isOk();
	}

}
