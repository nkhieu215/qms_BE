package com.fn.qms.planning.service;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

import com.fn.qms.utils.Utils;
import org.apache.http.HttpStatus;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.token.TokenManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.config.DataCache;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.Setting;
import com.fn.qms.planning.model.ProductPlanning;
import com.fn.qms.planning.model.UserWorkOrder;
import com.fn.qms.planning.rest.AuthenOutput;
import com.fn.qms.planning.rest.PlanningFilterInput;
import com.fn.qms.planning.rest.PlanningUpdateStoreInput;
import com.fn.qms.planning.rest.WorkOderInput;
import com.fn.qms.rest.GetPermissionsResponse;
import com.fn.qms.rest.ProductionStepResponse;
import com.fn.qms.utils.AppLog;

public class PlanningService {

	public static AuthenOutput athen;
	public static PlanningService request;

	public static PlanningService getInstall() {
		if (request == null) {
			request = new PlanningService();
		}
		if (athen == null) {
			athen = getToken();
		}
		return request;
	}

	public String sendRequest(Map<String, String> input, UrlPlanningConstant urlPath) {
		String response = "";
		try {
			Map<String, String> mapMessage = new HashMap();
			if (input != null) {
				mapMessage.putAll(input);
			}
		} catch (Exception e) {
			AppLog.error(e);
		}
		if (urlPath.getMethod().equals(Constant.POST) || urlPath.getMethod().equals(Constant.PUT)) {
			String datapost = input.get(Constant.DATA_JSON);
			try {
				response = this.postRequest(datapost, urlPath, urlPath.getMethod());
			} catch (Exception e) {
				AppLog.error(e);
			}
		} else if (urlPath.getMethod().equals(Constant.GET)) {
			response = this.getRequest(input, urlPath);
		} else if (urlPath.getMethod().equals(Constant.DELETE)) {
			response = this.deleteRequest(input, urlPath);
		}

		return response;
	}

	public String sendRequest(Map<String, String> input, UrlPlanningConstant urlPath, String planningToken) {
		String response = "";
		try {
			Map<String, String> mapMessage = new HashMap();
			if (input != null) {
				mapMessage.putAll(input);
			}
		} catch (Exception e) {
			AppLog.error(e);
		}
		if (urlPath.getMethod().equals(Constant.POST) || urlPath.getMethod().equals(Constant.PUT)) {
			String datapost = input.get(Constant.DATA_JSON);
			try {
				response = this.postRequest(datapost, urlPath, urlPath.getMethod());
			} catch (Exception e) {
				AppLog.error(e);
			}
		} else if (urlPath.getMethod().equals(Constant.GET)) {
			response = this.getRequest(input, urlPath, planningToken);
		} else if (urlPath.getMethod().equals(Constant.DELETE)) {
			response = this.deleteRequest(input, urlPath);
		}

		return response;
	}

	private String postRequest(String datapost, UrlPlanningConstant urlPath, String method) {
		RestTemplate restTemplate = new RestTemplate();
		String output = "";
		final String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE + urlPath.getUrl();
		URI uri;

		try {
			HttpHeaders headers = new HttpHeaders();
			// Please do not change this submission method. In most cases, the submission
			// method is form submission
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());

			HttpEntity<String> entity = new HttpEntity<String>(datapost, headers);
			// Just replace the exchange method
			if (Constant.POST.equals(method)) {
				ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);
				return response.getBody();
			} else if (Constant.PUT.equals(method)) {
				ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.PUT, entity, String.class);
				return response.getBody();
			} else {
				return "";
			}
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			if (statusCode == 401) {
				athen = getToken();
				this.postRequest(datapost, urlPath, method);
			}
		}
		return output;
	}

	private String deleteRequest(Map<String, String> input, UrlPlanningConstant urlPath) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getRequest(Map<String, String> input, UrlPlanningConstant urlPath) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String output = "";
		final String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE + urlPath.getUrl();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());

			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class,
					input);

			return response.getBody();
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			if (statusCode == 401) {
				athen = getToken();
				this.getRequest(input, urlPath);
			}
			AppLog.error(exception);
		}
		return output;
	}

	private String getRequest(Map<String, String> input, UrlPlanningConstant urlPath, String planningToken) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String output = "";
		final String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE + urlPath.getUrl();

		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
//			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());
			headers.set("Authorization", "Bearer " + planningToken);

			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class,
					input);

			if (response.getStatusCode().value() == 401) {
				getToken();
				this.getRequest(input, urlPath, planningToken);
			}

			return response.getBody();
		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			if (statusCode == 401) {
				athen = getToken();
				this.getRequest(input, urlPath);
			}
			AppLog.error(exception);
		}
		return output;
	}

	/**
	 * danh sach
	 * 
	 * @param input
	 * @return
	 */
	public ProductionStepResponse getWorkOder(PlanningFilterInput input) {
		ProductionStepResponse output = new ProductionStepResponse();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			inputQuery.put(Constant.DATA_JSON, mapper.writeValueAsString(input));
			String json = this.sendRequest(inputQuery, UrlPlanningConstant.PLANNING_WORK_ORDER);
			String jsonCount = this.sendRequest(inputQuery, UrlPlanningConstant.PLANNING_WORK_ORDER_COUNT);

//			
			// hardcode
//			String json = "[{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-702de651-9d54-4dd1-a29a-ecbadc89de92 [detached]\",\"id\":\"702de651-9d54-4dd1-a29a-ecbadc89de92\",\"woId\":\"WO-14\",\"line\":\"3658da49-bbdd-c50e-73ba-e29c58d3125d\",\"planningWorkOrderId\":14,\"branchName\":\"?i?n t? t? ??ng\",\"productOrder\":\"KH1-20211010\",\"lotNumber\":\"1\",\"productName\":\"Driver B?ng ?i?u khi?n c?nh RD-SC.M2.BLE (DC) - SMT\",\"bomVersion\":\"\",\"branchCode\":\"DTTD\",\"groupName\":\"T? SMT\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:31:32\",\"quantityPlan\":3000,\"startTime\":\"2021-11-02T07:00:00\",\"endTime\":\"2021-11-04T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"SMT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-774d2ef7-da29-4c79-abfe-7699d5429053 [detached]\",\"id\":\"774d2ef7-da29-4c79-abfe-7699d5429053\",\"woId\":\"WO-26\",\"planningWorkOrderId\":26,\"branchName\":\"?i?n t? t? ??ng\",\"productOrder\":\"KHH2-20211110\",\"lotNumber\":\"2\",\"productName\":\"?èn LED chi?u sáng ???ng CSD05 100W 5000K (QB)\",\"bomVersion\":\"1.1\",\"branchCode\":\"DTTD\",\"groupName\":\"T? THT\",\"productCode\":\"00041323\",\"createTime\":\"2021-11-23T14:17:19\",\"quantityPlan\":50000,\"startTime\":\"2021-11-09T07:00:00\",\"endTime\":\"2021-11-19T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"THT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-86a3a283-4c4c-4820-bb1b-fff1186f1b79 [detached]\",\"id\":\"86a3a283-4c4c-4820-bb1b-fff1186f1b79\",\"woId\":\"WO-17\",\"line\":\"a00fc79f-acd7-d2c3-a60c-5d9f8d0b4aab\",\"planningWorkOrderId\":17,\"branchName\":\"Công ngh? ph? tr?\",\"productOrder\":\"UK1-20211120\",\"lotNumber\":\"3\",\"productName\":\"?èn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\",\"bomVersion\":\"1.1\",\"branchCode\":\"CNPT\",\"groupName\":\"T? BTP 1\",\"productCode\":\"00024012\",\"createTime\":\"2021-11-23T00:29:21\",\"quantityPlan\":26000,\"startTime\":\"2021-11-19T07:00:00\",\"endTime\":\"2021-11-20T07:00:00\",\"groupCode\":\"BTP 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-97571822-a60b-abb3-4d00-353835f76735 [detached]\",\"id\":\"97571822-a60b-abb3-4d00-353835f76735\",\"planningWorkOrderId\":1002,\"lotNumber\":\"4\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-b9dfb339-cf9c-46b0-8325-fcd2203701ee [detached]\",\"id\":\"b9dfb339-cf9c-46b0-8325-fcd2203701ee\",\"woId\":\"WO-15\",\"line\":\"a00fc79f-acd7-d2c3-a60c-5d9f8d0b4aab\",\"planningWorkOrderId\":15,\"branchName\":\"LR LED\",\"productOrder\":\"UK-20210930\",\"lotNumber\":\"5\",\"productName\":\"?èn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\",\"bomVersion\":\"1.1\",\"branchCode\":\"LR LED\",\"groupName\":\"LR LED 1\",\"productCode\":\"00024012\",\"createTime\":\"2021-11-22T22:36:34\",\"quantityPlan\":26000,\"startTime\":\"2021-11-03T07:00:00\",\"endTime\":\"2021-11-04T07:00:00\",\"groupCode\":\"LR LED 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-d9f22129-260f-44c9-8155-7a0fed7c5d90 [detached]\",\"id\":\"d9f22129-260f-44c9-8155-7a0fed7c5d90\",\"woId\":\"WO-16\",\"line\":\"b7b0f0a6-52b9-97ab-ee6a-a7c73a5eb595\",\"planningWorkOrderId\":16,\"branchName\":\"LR COMPACT\",\"productOrder\":\"UK-20210930\",\"lotNumber\":\"6\",\"productName\":\"?èn LED panel MQL 1046 2x4 45W 3CCT (Yankon-Nora)\",\"bomVersion\":\"1.1\",\"branchCode\":\"LR COMPACT\",\"groupName\":\"LR COMPACT\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:36:34\",\"quantityPlan\":26000,\"startTime\":\"2021-11-04T07:00:00\",\"endTime\":\"2021-11-05T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"COMPACT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-f9aa1885-98c3-4c44-9c56-ea7c56519a7e [detached]\",\"id\":\"f9aa1885-98c3-4c44-9c56-ea7c56519a7e\",\"woId\":\"WO-13\",\"line\":\"3658da49-bbdd-c50e-73ba-e29c58d3125d\",\"planningWorkOrderId\":13,\"branchName\":\"Thi?t b? chi?u sáng\",\"productOrder\":\"KH1-20211010\",\"lotNumber\":\"7\",\"productName\":\"Driver B?ng ?i?u khi?n c?nh RD-SC.M2.BLE (DC) - SMT\",\"bomVersion\":\"1.1\",\"branchCode\":\"TBCS\",\"groupName\":\"T? LR TBCS 1\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:31:32\",\"quantityPlan\":3000,\"startTime\":\"2021-11-24T07:00:00\",\"endTime\":\"2021-11-25T07:00:00\",\"groupCode\":\"LRTBCS 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-fc75b674-de21-4108-ba67-e4fdb8685fed [detached]\",\"id\":\"fc75b674-de21-4108-ba67-e4fdb8685fed\",\"woId\":\"WO-18\",\"planningWorkOrderId\":18,\"productOrder\":\"UK1-20211120\",\"lotNumber\":\"8\",\"productName\":\"?èn LED panel MQL 1046 2x4 45W 3CCT (Yankon-Nora)\",\"bomVersion\":\"1.1\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-23T00:29:21\",\"quantityPlan\":26000,\"startTime\":\"2021-11-19T07:00:00\",\"endTime\":\"2021-11-24T07:00:00\",\"status\":\"DEACTIVE\"}]";

			AppLog.info(json);

			ProductPlanning arr[] = mapper.readValue(json, ProductPlanning[].class);

			List<ProductPlanning> lstProduct = new ArrayList<>();
			for (ProductPlanning productPlanning : arr) {
				lstProduct.add(productPlanning);
			}

			output.setTotal(Integer.parseInt(jsonCount));
			output.setLstProduct(lstProduct);
		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

	public GetPermissionsResponse getPermissions(String planningToken) {
		GetPermissionsResponse output = new GetPermissionsResponse();
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			String json = this.sendRequest(inputQuery, UrlPlanningConstant.PLANNING_GET_PERMISSION, planningToken);
//
			// hardcode
//			String json = "[{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-702de651-9d54-4dd1-a29a-ecbadc89de92 [detached]\",\"id\":\"702de651-9d54-4dd1-a29a-ecbadc89de92\",\"woId\":\"WO-14\",\"line\":\"3658da49-bbdd-c50e-73ba-e29c58d3125d\",\"planningWorkOrderId\":14,\"branchName\":\"?i?n t? t? ??ng\",\"productOrder\":\"KH1-20211010\",\"lotNumber\":\"1\",\"productName\":\"Driver B?ng ?i?u khi?n c?nh RD-SC.M2.BLE (DC) - SMT\",\"bomVersion\":\"\",\"branchCode\":\"DTTD\",\"groupName\":\"T? SMT\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:31:32\",\"quantityPlan\":3000,\"startTime\":\"2021-11-02T07:00:00\",\"endTime\":\"2021-11-04T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"SMT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-774d2ef7-da29-4c79-abfe-7699d5429053 [detached]\",\"id\":\"774d2ef7-da29-4c79-abfe-7699d5429053\",\"woId\":\"WO-26\",\"planningWorkOrderId\":26,\"branchName\":\"?i?n t? t? ??ng\",\"productOrder\":\"KHH2-20211110\",\"lotNumber\":\"2\",\"productName\":\"?èn LED chi?u sáng ???ng CSD05 100W 5000K (QB)\",\"bomVersion\":\"1.1\",\"branchCode\":\"DTTD\",\"groupName\":\"T? THT\",\"productCode\":\"00041323\",\"createTime\":\"2021-11-23T14:17:19\",\"quantityPlan\":50000,\"startTime\":\"2021-11-09T07:00:00\",\"endTime\":\"2021-11-19T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"THT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-86a3a283-4c4c-4820-bb1b-fff1186f1b79 [detached]\",\"id\":\"86a3a283-4c4c-4820-bb1b-fff1186f1b79\",\"woId\":\"WO-17\",\"line\":\"a00fc79f-acd7-d2c3-a60c-5d9f8d0b4aab\",\"planningWorkOrderId\":17,\"branchName\":\"Công ngh? ph? tr?\",\"productOrder\":\"UK1-20211120\",\"lotNumber\":\"3\",\"productName\":\"?èn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\",\"bomVersion\":\"1.1\",\"branchCode\":\"CNPT\",\"groupName\":\"T? BTP 1\",\"productCode\":\"00024012\",\"createTime\":\"2021-11-23T00:29:21\",\"quantityPlan\":26000,\"startTime\":\"2021-11-19T07:00:00\",\"endTime\":\"2021-11-20T07:00:00\",\"groupCode\":\"BTP 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-97571822-a60b-abb3-4d00-353835f76735 [detached]\",\"id\":\"97571822-a60b-abb3-4d00-353835f76735\",\"planningWorkOrderId\":1002,\"lotNumber\":\"4\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-b9dfb339-cf9c-46b0-8325-fcd2203701ee [detached]\",\"id\":\"b9dfb339-cf9c-46b0-8325-fcd2203701ee\",\"woId\":\"WO-15\",\"line\":\"a00fc79f-acd7-d2c3-a60c-5d9f8d0b4aab\",\"planningWorkOrderId\":15,\"branchName\":\"LR LED\",\"productOrder\":\"UK-20210930\",\"lotNumber\":\"5\",\"productName\":\"?èn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\",\"bomVersion\":\"1.1\",\"branchCode\":\"LR LED\",\"groupName\":\"LR LED 1\",\"productCode\":\"00024012\",\"createTime\":\"2021-11-22T22:36:34\",\"quantityPlan\":26000,\"startTime\":\"2021-11-03T07:00:00\",\"endTime\":\"2021-11-04T07:00:00\",\"groupCode\":\"LR LED 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-d9f22129-260f-44c9-8155-7a0fed7c5d90 [detached]\",\"id\":\"d9f22129-260f-44c9-8155-7a0fed7c5d90\",\"woId\":\"WO-16\",\"line\":\"b7b0f0a6-52b9-97ab-ee6a-a7c73a5eb595\",\"planningWorkOrderId\":16,\"branchName\":\"LR COMPACT\",\"productOrder\":\"UK-20210930\",\"lotNumber\":\"6\",\"productName\":\"?èn LED panel MQL 1046 2x4 45W 3CCT (Yankon-Nora)\",\"bomVersion\":\"1.1\",\"branchCode\":\"LR COMPACT\",\"groupName\":\"LR COMPACT\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:36:34\",\"quantityPlan\":26000,\"startTime\":\"2021-11-04T07:00:00\",\"endTime\":\"2021-11-05T07:00:00\",\"state\":\"COMPLETE\",\"groupCode\":\"COMPACT\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-f9aa1885-98c3-4c44-9c56-ea7c56519a7e [detached]\",\"id\":\"f9aa1885-98c3-4c44-9c56-ea7c56519a7e\",\"woId\":\"WO-13\",\"line\":\"3658da49-bbdd-c50e-73ba-e29c58d3125d\",\"planningWorkOrderId\":13,\"branchName\":\"Thi?t b? chi?u sáng\",\"productOrder\":\"KH1-20211010\",\"lotNumber\":\"7\",\"productName\":\"Driver B?ng ?i?u khi?n c?nh RD-SC.M2.BLE (DC) - SMT\",\"bomVersion\":\"1.1\",\"branchCode\":\"TBCS\",\"groupName\":\"T? LR TBCS 1\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-22T22:31:32\",\"quantityPlan\":3000,\"startTime\":\"2021-11-24T07:00:00\",\"endTime\":\"2021-11-25T07:00:00\",\"groupCode\":\"LRTBCS 1\",\"status\":\"DEACTIVE\"},{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-fc75b674-de21-4108-ba67-e4fdb8685fed [detached]\",\"id\":\"fc75b674-de21-4108-ba67-e4fdb8685fed\",\"woId\":\"WO-18\",\"planningWorkOrderId\":18,\"productOrder\":\"UK1-20211120\",\"lotNumber\":\"8\",\"productName\":\"?èn LED panel MQL 1046 2x4 45W 3CCT (Yankon-Nora)\",\"bomVersion\":\"1.1\",\"productCode\":\"00041437\",\"createTime\":\"2021-11-23T00:29:21\",\"quantityPlan\":26000,\"startTime\":\"2021-11-19T07:00:00\",\"endTime\":\"2021-11-24T07:00:00\",\"status\":\"DEACTIVE\"}]";

			AppLog.info(json);
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			output = mapper.readValue(json, GetPermissionsResponse.class);

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

	/**
	 * chi tieets
	 * 
	 * @param input
	 * @return
	 */
	public ProductionStepResponse getWorkOderDetail(WorkOderInput input) {

		ProductionStepResponse output = new ProductionStepResponse();
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			inputQuery.put("id", input.getId());
			String json = this.sendRequest(inputQuery, UrlPlanningConstant.PLANNING_WORK_ORDER_DETAIL);

//			String json="{\"_entityName\":\"PlanningWorkOrder\",\"_instanceName\":\"com.facenet.planningservice.entity.PlanningWorkOrder-fc75b674-de21-4108-ba67-e4fdb8685fed [detached]\",\"id\":\"fc75b674-de21-4108-ba67-e4fdb8685fed\",\"woId\":\"WO-18\",\"planningWorkOrderId\":18,\"productOrder\":\"UK1-20211120\",\"lotNumber\":\"8\",\"productName\":\"Driver TR135/80W.H SMT V2\",\"bomVersion\":\"1.1\",\"productCode\":\"00044729\",\"createTime\":\"2021-11-23T00:29:21\",\"quantityPlan\":26000,\"startTime\":\"2021-11-19T07:00:00\",\"endTime\":\"2021-11-24T07:00:00\",\"status\":\"DEACTIVE\",\"branchName\":\"LED\",\"groupName\":\"Nganh LED\"}";

			AppLog.info(json);
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);

			output.setPlanning(mapper.readValue(json, ProductPlanning.class));
		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

	/**
	 * chi tieet cac cong doan sx
	 * 
	 * @param input
	 * @return
	 */
	public ProductionStepResponse getUserWorkOrderDetail(PlanningFilterInput input) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProductionStepResponse output = new ProductionStepResponse();
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			inputQuery.put(Constant.DATA_JSON, mapper.writeValueAsString(input));
			String json = this.sendRequest(inputQuery, UrlPlanningConstant.PLANNING_WORK_ORDER_USER);

//			String json = "[{\"_entityName\":\"WorkOrderStage\",\"_instanceName\":\"com.facenet.planningservice.entity.WorkOrderStage-53c3fbfa-d77c-7263-36c8-fe59fdc4fc7b [detached]\",\"id\":\"53c3fbfa-d77c-7263-36c8-fe59fdc4fc7b\",\"workOrder\":\"WO-1020\",\"stageName\":\"Rút nghiệm vật tư đầu vào theo BOM\",\"userName\":\"person1\",\"stageCode\":\"1\",\"employeeGroupCode\":\"userGroupCode2\",\"productName\":\"Đèn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\"},{\"_entityName\":\"WorkOrderStage\",\"_instanceName\":\"com.facenet.planningservice.entity.WorkOrderStage-a50eaae7-7be8-d393-1cff-623973918d96 [detached]\",\"id\":\"a50eaae7-7be8-d393-1cff-623973918d96\",\"workOrder\":\"WO-1020\",\"stageName\":\"Kiểm tra quá trình sản xuất\",\"userName\":\"person3\",\"stageCode\":\"10\",\"employeeGroupCode\":\"userGroupCode1\",\"productName\":\"Đèn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\"},{\"_entityName\":\"WorkOrderStage\",\"_instanceName\":\"com.facenet.planningservice.entity.WorkOrderStage-b54cc57f-19d9-4ee3-a847-196727159231 [detached]\",\"id\":\"b54cc57f-19d9-4ee3-a847-196727159231\",\"workOrder\":\"WO-1020\",\"stageName\":\"Rút nghiệm vật tư đầu vào theo BOM\",\"userName\":\"person3\",\"stageCode\":\"1\",\"employeeGroupCode\":\"userGroupCode1\",\"productName\":\"Đèn LED Panel P07 300x600/24W.DA 6500K (KPK) SS\"}]";

			AppLog.info(json);
			UserWorkOrder[] lstWork = mapper.readValue(json, UserWorkOrder[].class);
			List<UserWorkOrder> lstUserWork = Arrays.asList(lstWork);

			List<UserWorkOrder> lstUserRes = new ArrayList<>();

			for (UserWorkOrder userWorkOrder : lstUserWork) {
				String stageCode = userWorkOrder.getStageCode();
				Setting setting = DataCache.getSettingByCode(stageCode);
				if(setting != null){
					userWorkOrder.setStageName(setting.getName());
					userWorkOrder.setStageCode(setting.getCode());
					lstUserRes.add(userWorkOrder);
				}
			}

			output.setLstUserDetail(lstUserRes);

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

	/**
	 * chi tieet cac cong doan sx
	 * 
	 * @param input
	 * @return
	 */
	public String updateStoreWo(PlanningUpdateStoreInput input) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ProductionStepResponse output = new ProductionStepResponse();
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			inputQuery.put("wo", input.getWo());
			inputQuery.put("quantity", input.getQuantity());
			inputQuery.put("mode", input.getMode());
			inputQuery.put("updateId", input.getUpdateId());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());

			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			// Just replace the exchange method
			String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE
					+ UrlPlanningConstant.PLANNING_UPDATE_WORK_ORDER_STORE.getUrl();
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.PUT, entity, String.class,
					inputQuery);
			String json = response.getBody();
			AppLog.info(json);
			return json;

		} catch (HttpStatusCodeException exception) {
			int statusCode = exception.getStatusCode().value();
			if (statusCode == 401) {
				athen = getToken();
				this.updateStoreWo(input);
			}
			AppLog.error(exception);
		} catch (Exception e) {
			AppLog.error(e);
		}
		return "";
	}

	public static AuthenOutput getToken() {

		Keycloak instance = Keycloak.getInstance(ConfigSSO.SSO_URL, ConfigSSO.SSO_REALM, ConfigSSO.SSO_USER,
				ConfigSSO.SSO_PASS, ConfigSSO.CLIENT_ID, ConfigSSO.CLIENT_SECRET);
		TokenManager tokenmanager = instance.tokenManager();
		String accessToken = tokenmanager.getAccessTokenString();

		AuthenOutput output = new AuthenOutput();
		output.setAccess_token(accessToken);
//		RestTemplate restTemplate = new RestTemplate();

//		final String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE + UrlPlanningConstant.GET_TOKEN.getUrl();
//		URI uri;
//		try {
//			uri = new URI(baseUrl);
//
//			HttpHeaders headers = new HttpHeaders();
//			// Please do not change this submission method. In most cases, the submission
//			// method is form submission
//			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//			headers.setBasicAuth("Basic Y2xpZW50OnNlY3JldA==");
//			headers.set("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
//
//			// Package parameters. Do not replace them with map and HashMap, otherwise the
//			// parameters cannot be passed
//			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//			params.add("username", "admin"); // Chinese supported
//			params.add("password", "admin");
//			params.add("grant_type", "password");
//
//			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
//					params, headers);
//			// Just replace the exchange method
//			ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class);
//
//			// Output results
//			System.out.println(response.getBody());
//
//			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
//					false);
//			output = mapper.readValue(response.getBody(), AuthenOutput.class);
//
//		} catch (Exception e) {
//			AppLog.error(e);
//		}
		return output;
	}

	public static AuthenOutput getToken(String username, String password) {
		AuthenOutput output = null;
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = ConfigPlaning.PLAINNING_URL_SERVICE + UrlPlanningConstant.GET_TOKEN.getUrl();
		URI uri;
		try {
			uri = new URI(baseUrl);

			HttpHeaders headers = new HttpHeaders();
			// Please do not change this submission method. In most cases, the submission
			// method is form submission
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.setBasicAuth("Basic Y2xpZW50OnNlY3JldA==");
			headers.set("Authorization", "Basic Y2xpZW50OnNlY3JldA==");

			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.add("username", username);
			params.add("password", password);
			params.add("grant_type", "password");

			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
					params, headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class);

			// Output results
			System.out.println(response.getBody());

			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			output = mapper.readValue(response.getBody(), AuthenOutput.class);

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}
}
