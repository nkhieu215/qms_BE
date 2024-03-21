package com.fn.qms.planning.service;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fn.planing.r2.ScanQRCheckNVLResponse;
import com.fn.planing.rest.DnlNvlResponse;
import com.fn.qms.rest.BaseResponse;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.token.TokenManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.constant.Constant;
import com.fn.qms.planning.model.PartNumberDetail;
import com.fn.qms.planning.rest.AuthenOutput;
import com.fn.qms.rest.ProfileResponse;
import com.fn.qms.utils.AppLog;


public class ProfileService {

	public static AuthenOutput athen;
	public static ProfileService request;
	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	public static ProfileService getInstall() {
		if (request == null) {
			request = new ProfileService();
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
				response = this.postRequest(datapost, urlPath);
			} catch (Exception e) {
				AppLog.error(e);
			}
		} else if (urlPath.getMethod().equals(Constant.GET)) {
			response = this.getRequest(input, urlPath);
		} 

		return response;
	}

	private String postRequest(String datapost, UrlPlanningConstant urlPath) {
		RestTemplate restTemplate = new RestTemplate();
		String output = "";
		final String baseUrl = ConfigPlaning.PROFILE_URL_SERVICE + urlPath.getUrl();
		URI uri;
		try {
			uri = new URI(baseUrl);

			HttpHeaders headers = new HttpHeaders();
			// Please do not change this submission method. In most cases, the submission
			// method is form submission
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());

			HttpEntity<String> entity = new HttpEntity<String>(datapost, headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

			return response.getBody();

		} catch (Exception e) {
			AppLog.error(e);
		}
		return output;
	}


	private String getRequest(Map<String, String> input, UrlPlanningConstant urlPath) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		String output = "";
		final String baseUrl = ConfigPlaning.PROFILE_URL_SERVICE + urlPath.getUrl();
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + this.athen.getAccess_token());
			
			// Package parameters. Do not replace them with map and HashMap, otherwise the
			// parameters cannot be passed			
			HttpEntity<String> entity = new HttpEntity<String>("", headers);
			// Just replace the exchange method
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class, input);
			return response.getBody();
		} catch (HttpStatusCodeException e) {
			AppLog.error(e);
			int statusCode = e.getStatusCode().value();
			if (statusCode == 401) {
				athen = getToken();
				this.getRequest(input, urlPath);
			}
		}
		return output;
	}

	/**
	 * chi tiet
	 *
	 * @return
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	public ScanQRCheckNVLResponse getProfile(String id) {
		try {
			Map<String, String> inputQuery = new HashMap<String, String>();
			inputQuery.put("id", id);
			String json = this.sendRequest(inputQuery, UrlPlanningConstant.DETAIL_PROFILE_BY_WO);
			AppLog.info(json);

			ScanQRCheckNVLResponse profile =mapper.readValue(json, ScanQRCheckNVLResponse.class);
			return profile;
		} catch (Exception e) {
				AppLog.error(e);
		}
		return null;
	}


	
	public static AuthenOutput getToken() {
		Keycloak instance = Keycloak.getInstance(ConfigSSO.SSO_URL, ConfigSSO.SSO_REALM, ConfigSSO.SSO_USER, ConfigSSO.SSO_PASS,ConfigSSO.CLIENT_ID, ConfigSSO.CLIENT_SECRET);                                                                                                      
		TokenManager tokenmanager = instance.tokenManager();
		String accessToken = tokenmanager.getAccessTokenString();
		AuthenOutput output = new AuthenOutput();
		output.setAccess_token(accessToken);
		return output;
	}
}
