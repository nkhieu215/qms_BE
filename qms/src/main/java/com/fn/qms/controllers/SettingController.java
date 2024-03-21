package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.bean.Request;
import com.fn.qms.rest.UserSettingResponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.SettingServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Validated
@RequestMapping("/setting")
public class SettingController extends BaseController{
	
	

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/menu")
	public UserSettingResponse getMenu(Authentication authen , HttpServletRequest requestClient) {
		AppLog.info(requestClient.getRequestURI());
		Request request = new Request();	
		SettingServiceBase service = new SettingServiceBase();		
		UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
		UserSettingResponse response = service.getMenuSetting(request,user,context);
		return response;
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
