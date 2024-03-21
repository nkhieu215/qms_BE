package com.fn.qms.controllers;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.dto.PqcQualityDTO;
import com.fn.qms.rest.*;
import com.fn.qms.services.PhotoelectricCheckService;
import com.fn.qms.services.QcCheckService;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Validated
@RequestMapping("/qc-check")
public class QcController extends BaseController {
	@Autowired
	QcCheckService qcCheckService;

	@PostMapping("/create")
	public BaseResponse createUpdate(Authentication authen, HttpServletRequest requestClient,
										   @RequestBody QcCheckRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response  =  qcCheckService.createUpdate(param);

		return response;
	}
	@DeleteMapping("/delete/{id}")
	public BaseResponse delete(Authentication authen, HttpServletRequest requestClient,@PathVariable(required=false,name="id") Long id) {

		AppLog.info(requestClient.getRequestURI() + "-delete-" + id.toString());
		BaseResponse response  =  qcCheckService.delete(id);
		return response;
	}

	@GetMapping("/detail/{id}")
	public QcCheckResponse detail(Authentication authen, HttpServletRequest requestClient,@PathVariable(required=false,name="id") Long id) {

		AppLog.info(requestClient.getRequestURI() + "-detail-" + id.toString());
		PqcQualityDTO dto  =  qcCheckService.getDetail(id);
		QcCheckResponse response = new QcCheckResponse();
		response.setPqcQualityDTO(dto);
		return response;
	}

}
