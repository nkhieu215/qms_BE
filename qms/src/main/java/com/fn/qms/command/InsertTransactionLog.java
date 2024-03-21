package com.fn.qms.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.models.TransactionHistory;
import com.fn.qms.repository.DAO.TransactionHistoryDAO;
import com.fn.qms.utils.AppLog;
import com.google.gson.Gson;

public class InsertTransactionLog implements Command {

	@Override
	public boolean execute(Context cntxt) throws Exception {
		ProcessContext context = (ProcessContext) cntxt;
		ApplicationContext ctx = context.getContext();
		Request request = context.getRequest();
		Response response = context.getResponse();
		Result result = context.getResult();
		AppLog.info("Insert log");

		try {
//			TransactionHistory log = new TransactionHistory();
//			log.setIp(request.getIpAddress());
//			log.setPath(request.getUrlPath());
//			
//			log.setRequestId(request.getRequestId());
//			
//			ObjectMapper objectMapper = new ObjectMapper();
//			log.setRequestContent(objectMapper.writeValueAsString(request.getRequestContent()));
//			log.setResponse(objectMapper.writeValueAsString(response));
//			log.setResponseCode(result.getResponseCode());
//			log.setServerIp(request.getIpServer());
//			log.setUserId(request.getPartnerId());
//			
//			TransactionHistoryDAO transactionHistoryDAO = ctx.getBean(TransactionHistoryDAO.class);
//			transactionHistoryDAO.save(log);
			
		} catch (Exception e) {
			AppLog.error(e);
		}

		return !SimpleResult.OK.isOk();
	}

}
