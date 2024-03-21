package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.repository.DAO.PQCWorkOrderDAO;
import com.fn.qms.repository.DAO.TinCheckDAO;
import com.fn.qms.rest.SolderCheckResponse;
import com.fn.qms.rest.SolderErrorRequest;
import com.fn.qms.rest.SolderRequest;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class SolderCheckService {

    @Autowired
    PqcDttdSolderRepository pqcDttdSolderRepository;

    @Autowired
    PqcDttdSolderErrorRepository pqcDttdSolderErrorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;
    public SolderCheckResponse solderCheckCreateUpdate(SolderRequest param) {
        Validator.Result result = Validator.Result.OK;
        SolderCheckResponse response = new SolderCheckResponse();
        PqcDttdSolderCheck check = modelMapper.map(param.getData(), PqcDttdSolderCheck.class);

        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.SOLDER,"",pqcWorkOrder, check.getConclude(), check.getNote());
        }

        pqcDttdSolderRepository.save(check);
        response.setIdCheck(check.getDttdSolderCheckId());
        return response;
    }

    public SolderCheckResponse removeByType(Long id) {
        Validator.Result result = Validator.Result.OK;
        SolderCheckResponse response = new SolderCheckResponse();
        pqcDttdSolderRepository.deleteById(id);

        return response;
    }

    public SolderCheckResponse addError(SolderErrorRequest data) {
        Validator.Result result = Validator.Result.OK;
        SolderCheckResponse response = new SolderCheckResponse();
        response.setResult(result);

        PqcDttdSolderError check = modelMapper.map(data.getData(), PqcDttdSolderError.class);
        check.setDttdType("SOLDER");
        pqcDttdSolderErrorRepository.save(check);
        return response;
    }

    public SolderCheckResponse removeError(Long id) {
        Validator.Result result = Validator.Result.OK;
        SolderCheckResponse response = new SolderCheckResponse();
        response.setResult(result);

            pqcDttdSolderErrorRepository.deleteById(id);
        return response;
    }

    public SolderCheckResponse detail(Long id) {
        Validator.Result result = Validator.Result.OK;
        SolderCheckResponse response = new SolderCheckResponse();
        response.setResult(result);

        PqcDttdSolderCheck check = pqcDttdSolderRepository.findById(id).get();
        SolderCheckDTO checkDTO = modelMapper.map(check, SolderCheckDTO.class);
        response.setDetail(checkDTO);
        return response;
    }
}
