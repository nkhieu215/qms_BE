package com.fn.qms.services;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.fn.qms.constant.Constant;
import com.fn.qms.dto.SolderCheckDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.PqcTinErrorRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.AssemblesCheckResponse;
import com.fn.qms.rest.SolderCheckResponse;
import com.fn.qms.rest.TinErrorRequest;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.Serial;
import com.fn.qms.dto.TinCheckDTO;
import com.fn.qms.dto.TinCheckSerialDTO;
import com.fn.qms.repository.PqcTinCheckRepository;
import com.fn.qms.repository.TinCheckSerialRepository;
import com.fn.qms.repository.DAO.PQCWorkOrderDAO;
import com.fn.qms.repository.DAO.TinCheckDAO;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.utils.AppLog;


@Service
public class TinCheckService {
	
	@Autowired
	TinCheckSerialRepository tinCheckSerial;
	@Autowired
	PqcTinErrorRepository pqcTinErrorRepository;
	@Autowired
	PqcTinCheckRepository tinCheck;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired PQCWorkOrderDAO orderDAO;
	@Autowired TinCheckDAO tinDao;

	@Autowired
	PqcWorkOrderRepository pqcWorkOrderRepository;
	
	public TinCheckSerialResponse pqcTinCheckSerial(TinCheckSerialDTO dto) {
		Validator.Result result = Validator.Result.OK;
		TinCheckSerialResponse response = new TinCheckSerialResponse();		
		PqcDttdTinCheckSerial checkSerial = modelMapper.map(dto, PqcDttdTinCheckSerial.class);		
		
		try {
			ObjectMapper map = new ObjectMapper();
			String serial = map.writeValueAsString(dto.getLstSerial());
			checkSerial.setSerial(serial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tinCheckSerial.save(checkSerial);
		response.setIdCheck(checkSerial.getId());
		response.setResult(result);
		return response;
	}
	
	/**
	 * laay danh sach theo workorder
	 * @param workorderId
	 * @return
	 */
	public TinCheckSerialResponse  lstTinCheckByWorkOrder(Long workorderId) {		
		TinCheckSerialResponse response = new TinCheckSerialResponse ();
		Validator.Result result = Validator.Result.OK;
		response.setResult(result);
		List<PqcDttdTinCheckSerial> lst =  tinCheckSerial.lstTinCheckByWorkOrder(workorderId);
		
		List<TinCheckSerialDTO> postDtoList = Arrays.asList(modelMapper.map(lst, TinCheckSerialDTO[].class));
		
		if(postDtoList != null && !postDtoList.isEmpty()) {
			ObjectMapper map = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			for (TinCheckSerialDTO tinCheckSerialDTO : postDtoList) {
				String json = tinCheckSerialDTO.getSerial();
				try {
					List<Serial> lstSerial =Arrays.asList(map.readValue(json, Serial[].class));
					tinCheckSerialDTO.setLstSerial(lstSerial);
					
				}catch (Exception e) {
					AppLog.error(e);
				}
			}
		}
		
		response.setLstTinCheckSerial(postDtoList);
		return response;
	}

	public TinCheckSerialResponse removeByType(Long id, String type) {
		TinCheckSerialResponse response = new TinCheckSerialResponse ();
		Validator.Result result = Validator.Result.OK;
		response.setResult(result);

		if("check".equalsIgnoreCase(type)){
			tinCheck.deleteTinCheck(id);
		}
		else{
			tinCheckSerial.deleteTinCheckSerial(id);
		}
		return response;
	}

	/**
	 * Luu thong tin kiem tra kem thiec
	 * @param param
	 * @return
	 */
	public TinCheckSerialResponse addNewTinCheck( TinCheckDTO param) {
		Validator.Result result = Validator.Result.OK;
		TinCheckSerialResponse response = new TinCheckSerialResponse();				
		PqcDttdTinCheck check = modelMapper.map(param, PqcDttdTinCheck.class);
		check.setDttdCheckId(param.getId());

		if(check.getWorkOrderId()!= null){
			PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
			Utils.buildPqcWarning(Constant.TIN,"",pqcWorkOrder, check.getConclude(), check.getNote());
		}

		tinCheck.save(check);
		response.setIdCheck(check.getDttdCheckId());
		return response;
	}

    public TinCheckSerialResponse removeError(Long id) {
		TinCheckSerialResponse response = new TinCheckSerialResponse ();
		Validator.Result result = Validator.Result.OK;
		response.setResult(result);
		pqcTinErrorRepository.deleteById(id);
		return response;
    }

	public TinCheckSerialResponse addError(TinErrorRequest param) {
		Validator.Result result = Validator.Result.OK;
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		response.setResult(result);

		PqcDttdTinError check = modelMapper.map(param.getData(), PqcDttdTinError.class);
		check.setDttdType("TIN");
		pqcTinErrorRepository.save(check);
		return response;
	}

	public TinCheckSerialResponse detail(Long id) {
		Validator.Result result = Validator.Result.OK;
		TinCheckSerialResponse response = new TinCheckSerialResponse();
		response.setResult(result);

		PqcDttdTinCheck check = tinCheck.findById(id).get();
		TinCheckDTO checkDTO = modelMapper.map(check, TinCheckDTO.class);
		response.setDetail(checkDTO);
		return response;
	}
}
