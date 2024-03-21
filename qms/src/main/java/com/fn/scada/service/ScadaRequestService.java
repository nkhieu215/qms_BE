package com.fn.scada.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.constant.Constant;
import com.fn.qms.planning.rest.ScadaAuthenInput;
import com.fn.qms.planning.rest.ScadaAuthenOutput;
import com.fn.qms.planning.service.ConfigPlaning;
import com.fn.qms.planning.service.UrlPlanningConstant;
import com.fn.qms.rest.ScadaAssetsRequest;
import com.fn.qms.rest.ScadaAssetsResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.apache.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;


public class ScadaRequestService {

	public static ScadaAuthenOutput athen;
	public static ScadaRequestService request;
	
	public static ScadaRequestService getInstall() {
		if (request == null) {
			request = new ScadaRequestService();
		}
		if (athen == null) {
			athen = getToken();
		}
		return request;
	}

	public String sendRequest(Map<String, String> input, UrlScadaConstant urlPath) {
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
				response = this.postRequest(datapost, urlPath);
			} catch (Exception e) {
				AppLog.error(e);
			}
		} else if (urlPath.getMethod().equals(Constant.GET)) {
			response = this.getRequest(input, urlPath);
		} 

		return response;
	}

	private String postRequest(String datapost, UrlScadaConstant urlPath) {
		RestTemplate restTemplate = new RestTemplate();
		String output = "";
		final String baseUrl = ConfigPlaning.SCADA_URL_SERVICE + urlPath.getUrl();
		URI uri;
		try {
			uri = new URI(baseUrl);

			HttpHeaders headers = new HttpHeaders();
			// Please do not change this submission method. In most cases, the submission
			// method is form submission
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getToken());

			HttpEntity<String> entity = new HttpEntity<String>(datapost, headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

			if (response.getStatusCode().equals(HttpStatus.SC_UNAUTHORIZED)) {
				getToken();
				this.postRequest(datapost, urlPath);
			}

			return response.getBody();

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}
	
	private String getRequest(Map<String, String> input, UrlScadaConstant urlPath) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String output = "";
		final String baseUrl;
		if(Utils.isNull(urlPath.getHost())){
			baseUrl = ConfigPlaning.SCADA_URL_SERVICE + urlPath.getUrl();
		}else{
			baseUrl = urlPath.getHost() + urlPath.getUrl();
		}
		AppLog.info(baseUrl);
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.set("X-Authorization", "Bearer " + this.athen.getToken());

			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class,input);

			return response.getBody();
		} catch (HttpClientErrorException.Unauthorized e) {
			AppLog.error(e);
			athen = getToken();
			this.getRequest(input, urlPath);
		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

	/**
	 * danh sach may
	 * 
	 * @param input
	 * @return
	 */
	public ScadaAssetsResponse getAssetsResponseV2(ScadaAssetsRequest input) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			String jsonRequest = mapper.writeValueAsString(input);
			Map<String,String> inputQuery =new ObjectMapper().readValue(jsonRequest, HashMap.class);			
			String json = this.sendRequest(inputQuery, UrlScadaConstant.SCADA_GET_ASSETS_V2);
			AppLog.info(json);
			ScadaAssetsResponse response = mapper.readValue(json, ScadaAssetsResponse.class);
			return response;

		} catch (Exception e) {
			AppLog.error(e);
		}
		return null;
	}


	/**
	 * @param input
	 * @param url
	 * @return
	 */
	public ScadaAssetsResponse getAssetsResponseV2(ScadaAssetsRequest input, UrlScadaConstant url) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			String jsonRequest = mapper.writeValueAsString(input);
			Map<String,String> inputQuery =new ObjectMapper().readValue(jsonRequest, HashMap.class);
			String json = this.sendRequest(inputQuery, url);
			AppLog.info(json);
			ScadaAssetsResponse response = mapper.readValue(json, ScadaAssetsResponse.class);
			return response;

		} catch (Exception e) {
			AppLog.error(e);
		}
		return null;
	}

	/**
	 * @param input
	 * @param url
	 * @return
	 */
	public String  getJson(ScadaAssetsRequest input, UrlScadaConstant url) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			String jsonRequest = mapper.writeValueAsString(input);
			Map<String,String> inputQuery =new ObjectMapper().readValue(jsonRequest, HashMap.class);
			String json = this.sendRequest(inputQuery, url);
			AppLog.info(json);
			return json;

		} catch (Exception e) {
			AppLog.error(e);
		}
		return null;
	}


	public static ScadaAuthenOutput getToken() {
		ScadaAuthenOutput output = null;
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = ConfigPlaning.SCADA_URL_SERVICE + UrlPlanningConstant.SCADA_GET_TOKEN.getUrl();
		URI uri;
		try {
			uri = new URI(baseUrl);

			HttpHeaders headers = new HttpHeaders();
			// Please do not change this submission method. In most cases, the submission
			// method is form submission
			headers.setBasicAuth("Basic Y2xpZW50OnNlY3JldA==");
			headers.set("Authorization", "Basic Y2xpZW50OnNlY3JldA==");
			headers.setContentType(MediaType.APPLICATION_JSON);
			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed
			ScadaAuthenInput params = new ScadaAuthenInput("ecyberlinh@gmail.com", "ATTT@123");

			String json = new ObjectMapper().writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(
					json, headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class);

			// Output results
			System.out.println(response.getBody());

			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			output = mapper.readValue(response.getBody(), ScadaAuthenOutput.class);

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}

}
