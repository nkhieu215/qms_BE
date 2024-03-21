package com.fn.qms.service.base;

import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.ProductionStepResponse;
import com.fn.qms.rest.ProfileResponse;
import com.fn.qms.rest.service.ProductionCRUDService;
import com.fn.qms.rest.service.SAPService;
import com.fn.qms.rest.service.ProductionPlaningService;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;

public class ProductionServiceBase {
	ProcessContext ctx;

	public ProcessContext getContextRequest() {
		return ctx;
	}

	public ProductionServiceBase() {
		ctx = new ProcessContext();
		Response response = new Response();
		ctx.setResponse(response);
	}

	/**
	 * chi tiet
	 * @param request
	 * @param user
	 * @return
	 */
	public ProductionStepResponse detailPlanningOrder(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		SAPService service = new SAPService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		ProductionStepResponse resp = new ProductionStepResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (ProductionStepResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}

	/**
	 * danh sach planning
	 * @param request
	 * @param user
	 * @param context
	 * @return
	 */
	public ProductionStepResponse getOrderPlanningList(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		ProductionPlaningService service = new ProductionPlaningService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		ProductionStepResponse resp = new ProductionStepResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (ProductionStepResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}

	public ProductionStepResponse crud(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		ProductionCRUDService service = new ProductionCRUDService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		ProductionStepResponse resp = new ProductionStepResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (ProductionStepResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}


	/**
	 * lay danh sach thong tin kiem tra theo user
	 * @param request
	 * @param user
	 * @param context
	 * @return
	 */
	public PqcWorkOrderResponse getLstWorkOrderStep(Request request, UserDetailsImpl user, ApplicationContext context) {
		ctx.setRequest(request);
		ctx.setUser(user);
		ctx.setContext(context);
		ProductionCRUDService service = new ProductionCRUDService();		
		TransactionLogService logService = new TransactionLogService();
		try {
			service.execute(ctx);
			logService.execute(ctx);
		} catch (Exception ex) {
			AppLog.error(ex);
			ctx.setResult(Validator.Result.UNKNOWN);
		}
		Validator.Result result = ctx.getResult();
		PqcWorkOrderResponse resp = new PqcWorkOrderResponse();
		if(result.isOk()) {
			Response response = ctx.getResponse();
			resp = (PqcWorkOrderResponse) response.getObj();
		}
		resp.setResult(result);
		return resp;
	}	
	
}
