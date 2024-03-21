package com.fn.rd.service;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.DrawTestNvlDTO;
import com.fn.qms.models.PqcDrawNvl;
import com.fn.qms.models.PqcDrawTestNvl;
import com.fn.qms.planning.model.Feeder;
import com.fn.qms.planning.model.PartNumber;
import com.fn.qms.planning.model.PartNumberDetail;
import com.fn.qms.planning.service.ProfileService;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.NvlResponse;
import com.fn.qms.rest.ProfileResponse;
import com.fn.qms.utils.Utils;
import com.fn.rd.dto.ErrorDTO;
import com.fn.rd.models.ErrorList;
import com.fn.rd.repository.ErrorListRepository;
import com.fn.rd.rest.ErrorListResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

	@Autowired
	ErrorListRepository errorListRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BaseResponse create(ErrorDTO dto) {
		Validator.Result result = Validator.Result.OK;
		BaseResponse response = new BaseResponse();
		ErrorList errorList = new ErrorList();
		errorList.setName(dto.getName());
		errorList.setDescription(dto.getDescription());
		errorList.setErrorCode(dto.getErrorCode());
		errorList.setParentId(dto.getParentId());
		errorList.setId(dto.getId());

		errorList = errorListRepository.save(errorList);

		if (dto.getErrChild() != null && !dto.getErrChild().isEmpty()) {
			for ( ErrorDTO errorDTO : dto.getErrChild()) {
				ErrorList error = modelMapper.map(errorDTO, ErrorList.class);
				error.setParentId(errorList.getId());
				errorListRepository.save(error);
			}
		}
		response.setId(errorList.getId());
		response.setResult(result);
		return response;
	}

	public BaseResponse removeById(Long id) {
		Validator.Result result = Validator.Result.OK;
		BaseResponse response = new BaseResponse();
		ErrorList errorList = errorListRepository.findById(id).get();

		if (errorList != null) {
			errorListRepository.deleteFromParentId(id);
			errorListRepository.delete(errorList);
		}
		response.setResult(result);
		return response;
	}

	public ErrorListResponse getById(Long id) {
		Validator.Result result = Validator.Result.OK;
		ErrorListResponse response = new ErrorListResponse();
		ErrorList error =  errorListRepository.findById(id).get();
		ErrorDTO dto = modelMapper.map(error, ErrorDTO.class);
		response.setError(dto);
		return response;
	}
}
