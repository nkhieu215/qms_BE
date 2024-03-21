package com.fn.qms.controllers;

import com.fn.qms.dto.PqcPhotoelectricDTO;
import com.fn.qms.dto.PqcPhotoelectricLkdtDTO;
import com.fn.qms.rest.*;
import com.fn.qms.services.MountCheckService;
import com.fn.qms.services.PhotoelectricCheckService;
import com.fn.qms.utils.AppLog;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.PathParam;

@RestController
@Validated
@RequestMapping("/photoelectric")
public class PhotoelectricController extends BaseController {
	@Autowired
	PhotoelectricCheckService photoelectricCheckService;

	@PostMapping("/create")
	public BaseResponse createUpdate(Authentication authen, HttpServletRequest requestClient,
										   @RequestBody PhotoelectricRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response  =  photoelectricCheckService.createUpdate(param);

		return response;
	}
	@DeleteMapping("/delete/{id}")
	public BaseResponse delete(Authentication authen, HttpServletRequest requestClient,@PathVariable(required=false,name="id") Long id) {

		AppLog.info(requestClient.getRequestURI() + "-delete-" + id.toString());
		BaseResponse response  =  photoelectricCheckService.delete(id);
		return response;
	}

	@GetMapping("/detail/{id}")
	public PhotoelectricResponse detail(Authentication authen, HttpServletRequest requestClient,@PathVariable(required=false,name="id") Long id) {

		AppLog.info(requestClient.getRequestURI() + "-detail-" + id.toString());
		PqcPhotoelectricDTO dto  =  photoelectricCheckService.getDetail(id);
		PhotoelectricResponse response = new PhotoelectricResponse();
		response.setPhotoelectricDTO(dto);
		return response;
	}

	@DeleteMapping("/delete-prod/{id}")
	public BaseResponse deleteProd(Authentication authen, HttpServletRequest requestClient,@PathVariable(required=false,name="id") Long id) {

		AppLog.info(requestClient.getRequestURI() + "-delete-" + id.toString());
		BaseResponse response  =  photoelectricCheckService.deleteProd(id);
		return response;
	}

	@PostMapping("/create-prod")
	public BaseResponse createUpdateProd(Authentication authen, HttpServletRequest requestClient,
									 @RequestBody PhotoelectricProdRequest param) {

		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
		BaseResponse response  =  photoelectricCheckService.createUpdateProd(param);

		return response;
	}
}
