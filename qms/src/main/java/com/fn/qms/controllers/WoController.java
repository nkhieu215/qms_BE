package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.dto.WoCreateDTO;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.services.TinCheckService;
import com.fn.qms.services.WoService;
import com.fn.qms.utils.AppLog;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/pqc-wo")
public class WoController extends BaseController{
	
	@Autowired
	WoService woService;
	
	@PostMapping("/pqc-create")// thêm mới thông tin lệnh sản xuất đang chờ
	public PqcWorkOrderResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody WoCreateDTO param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());		
		PqcWorkOrderResponse response = new PqcWorkOrderResponse();
		
		response  =  woService.pqcCreateUpdateWo(param);
		
		return response;
	}

	@GetMapping("/pqc-lst-check/{id}")
	public PqcWorkOrderResponse getLstCheck(Authentication authen, HttpServletRequest requestClient,
											@PathVariable("id")  Long id) {
		PqcWorkOrderResponse response = woService.getLstCheckByWo(id);
		return response;
	}
	
}
