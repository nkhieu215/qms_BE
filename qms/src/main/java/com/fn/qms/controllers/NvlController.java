package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fn.planing.r2.ScanQRCheckNVLResponse;
import com.fn.planing.rest.DnlNvlResponse;
import com.fn.qms.services.StorageService;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
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

import com.fn.qms.dto.NvlCreateDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.dto.WoCreateDTO;
import com.fn.qms.rest.NvlResponse;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.ProfileResponse;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.services.NVLService;
import com.fn.qms.services.TinCheckService;
import com.fn.qms.services.WoService;
import com.fn.qms.utils.AppLog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/pqc-nvl")
public class NvlController extends BaseController{
	@Autowired
	StorageService storageService;

	@Autowired
	NVLService nvlService;
	
	@PostMapping("/create")
	public NvlResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient,
			@Valid @RequestBody NvlCreateDTO param) {
		
		AppLog.info(requestClient.getRequestURI() + "-" + param.toString());		
		NvlResponse response  =  nvlService.createNvlCheck(param);
		return response;
	}
	
	@GetMapping("/get-lst-check-by-order-id/{id}")
	public NvlResponse getLstCheckByOrderId(Authentication authen, HttpServletRequest requestClient,@PathVariable("id")  Long id) {		
		NvlResponse response  =  nvlService.getLstCheckByOrderId(id);
		return response;
	}
	
	@DeleteMapping("/remove/{id}")
	public NvlResponse remove(Authentication authen, HttpServletRequest requestClient,
			@PathVariable("id")  Long id) {		
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());		
		NvlResponse response =  nvlService.removeById(id);
		return response;
	}


	@PostMapping("/upload-image/{id}/{woId}")
	public NvlResponse uploadImage(Authentication authen, HttpServletRequest requestClient,
							  @PathVariable("id")  Long id, @PathVariable("woId")  Long woId, @RequestParam("file") MultipartFile[] files) {
		AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
		NvlResponse response =  nvlService.uploadImage(id,woId, files);
		return response;
	}

	@GetMapping("/img/{drawNVLId}")
	public NvlResponse getLstImg(Authentication authen, HttpServletRequest requestClient, @PathVariable("drawNVLId")  Long drawNVLId) {
		AppLog.info(requestClient.getRequestURI());
		NvlResponse response =  nvlService.getLstImgByDrawNvl(drawNVLId);
		return response;
	}

	@PostMapping("/get-profile-detail/{profileId}")
	public ScanQRCheckNVLResponse getProfileDetail(Authentication authen, HttpServletRequest requestClient,
												   @PathVariable("profileId")  String  profileId) {
		return nvlService.getProfileDetail(profileId);
	}

}
