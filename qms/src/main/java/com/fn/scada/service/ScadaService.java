package com.fn.scada.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.planning.service.UrlPlanningConstant;
import com.fn.qms.rest.*;
import com.fn.qms.utils.AppLog;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.scada.dto.ScadaKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.models.PqcStepMachine;
import com.fn.qms.repository.PqcStepMachineRepository;


@Service
public class ScadaService {

	public MachineResponse getMachine() {
		Validator.Result result = Result.OK;
		MachineResponse response =  new MachineResponse();		
		ScadaAssetsRequest input = new ScadaAssetsRequest();
		input.setPage(0);
		input.setPageSize(200);
		input.setSortOrder("DESC");
		input.setSortProperty("createdTime");
		input.setType("stage");		
		ScadaAssetsResponse responseRequest = ScadaRequestService.getInstall().getAssetsResponseV2(input);		
		response.setResult(result);
		return response;
	}

	/**
	 * lay danh sach loi
	 * @return
	 */
	public ErrorLstScadaResponse getErrorLstScada() {		
		ErrorLstScadaResponse response = new ErrorLstScadaResponse();
		
		ScadaAssetsRequest input = new ScadaAssetsRequest();
		input.setPage(0);
		input.setPageSize(500);
		input.setSortOrder("DESC");
		input.setSortProperty("createdTime");
		input.setType("error");		
		
		ScadaAssetsResponse responseRequest = ScadaRequestService.getInstall().getAssetsResponseV2(input);		
		
		response.setData(responseRequest.getData());
		return response;
	}

	@Autowired
	PqcStepMachineRepository machinerepo; 
	public ErrorMachineResponse getErrorByStep(String sapCode, String step) {

		ErrorMachineResponse response = new ErrorMachineResponse();
		ScadaAssetsRequest input = new ScadaAssetsRequest();
		
		List<PqcStepMachine> lstMachine = machinerepo.findListByCode(step);
		if(lstMachine != null) {
			PqcStepMachine machinhe = lstMachine.get(0);
			String [] lstMachineCode = machinhe.getLstMachine().split(",");
			for (String string : lstMachineCode) {
				input.setEntityId(string);
				input.setEntityType("ASSET");				
				ScadaAssetsResponse responseRequest = ScadaRequestService.getInstall().getAssetsResponseV2(input);		
			}
			
		}
		return null;
	}

	/**
	 * lay danh sach loi
	 * @return
	 */
	public ScadaResponse getByType(ScadaAssetsRequest input) {
		ScadaResponse response = new ScadaResponse();
		ScadaAssetsResponse responseRequest = ScadaRequestService.getInstall().getAssetsResponseV2(input);
		response.setData(responseRequest.getData());
		return response;
	}

	/**
	 * lay danh sach loi
	 * @return
	 */
	public ScadaResponse getByType(ScadaAssetsRequest input, UrlScadaConstant url) {
		ScadaResponse response = new ScadaResponse();
		ScadaAssetsResponse responseRequest = ScadaRequestService.getInstall().getAssetsResponseV2(input, url);
		response.setData(responseRequest.getData());
		return response;
	}

	public String getByTypeReturnJson(ScadaAssetsRequest input, UrlScadaConstant url) {
		String json = ScadaRequestService.getInstall().getJson(input, url);
		return json;
	}

	public List<ScadaKeyValue> getGroupByError(ScadaAssetsRequest input, UrlScadaConstant url){
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json =  ScadaRequestService.getInstall().getJson(input, url);
		try {
			List<ScadaKeyValue> lst = Arrays.asList(mapper.readValue(json, ScadaKeyValue[].class));
			return lst;
		}catch (Exception ex){

		}
		return null;
	}

}
