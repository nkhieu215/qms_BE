package com.fn.qms.services;

import com.fn.planing.rest.DnlNvlResponse;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.DrawNvlImageDTO;
import com.fn.qms.dto.IqcNvlDTO;
import com.fn.qms.dto.NvlCreateDTO;
import com.fn.qms.dto.PqcDrawNvlTestDTO;
import com.fn.qms.models.IqcElectronicComponent;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.models.PqcNvlImage;
import com.fn.qms.planning.service.ProfileService;
import com.fn.qms.repository.*;
import com.fn.qms.rest.NvlResponse;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;


@Service
public class IqcCheckNvlService {

	@Autowired
	ElectronicComponentRepository repository;
	@Autowired
	IqcAuditResultNvlRepository auditResultNvlRepository;

	@Autowired
	IqcElectCompErrRepository iqcElectCompErrRepository;

	@Autowired
	IqcAuditResultParamRepository auditResultParamRepository;

	@Autowired
	IqcAuditResultLkdtRepository auditResultLkdtRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	StorageService storageService;

	public NvlResponse createNvlCheck(IqcNvlDTO dto) {
		Validator.Result result = Validator.Result.OK;
		NvlResponse response = new NvlResponse();

		IqcElectronicComponent component = modelMapper.map(dto.getComponent(), IqcElectronicComponent.class);
		if(component.getId() != null){
			IqcElectronicComponent checkDraw  = repository.findById(component.getId()).get();
			component.setCreatedAt(checkDraw.getCreatedAt());
			component.setUpdatedAt(new Date());
			component.setTemplateCode(checkDraw.getTemplateCode());
			component.setElecCompCode(checkDraw.getElecCompCode());
		}
		repository.save(component);


		response.setResult(result);
		return response;
	}

}
