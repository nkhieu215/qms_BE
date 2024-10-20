package com.fn.qms.controllers;

import com.fn.qms.dto.Scan100DTO;
import com.fn.qms.dto.warning.Scan100Warning;
import com.fn.qms.models.PqcScan100;
import com.fn.qms.rest.*;
import com.fn.qms.services.AssemblesCheckService;
import com.fn.qms.services.Scan100Service;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/scan-100")
public class PqcScan100Controller extends BaseController {
	@Autowired
	Scan100Service scan100Service;

	@PostMapping("/create")
	public Scan100Response solderCheckCreate(Authentication authen, HttpServletRequest requestClient,
											 @Valid @RequestBody Scan100Request param) {
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		Scan100Response response  =  scan100Service.createUpdate(param);
		return response;
	}
	@PostMapping("/update")
	public void update(@RequestBody Scan100Request request){
		this.scan100Service.update(request);
	}
	@PostMapping("/send-message")
	public void scanMessage(@RequestBody Scan100Warning request){
		this.scan100Service.sendMessage(request);
	}
}
