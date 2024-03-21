package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.InterchangeabilityCheckDTO;
import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.models.PqcDttdInterchangeabilityCheck;
import com.fn.qms.models.PqcDttdMountCompCheck;
import com.fn.qms.models.PqcDttdMountError;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.repository.PqcDttdMountErrorRepository;
import com.fn.qms.repository.PqcInterchangeabilityCheckRepository;
import com.fn.qms.repository.PqcMountCompCheckRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.*;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InterchangeabilityService {

    @Autowired
    PqcInterchangeabilityCheckRepository pqcInterchangeabilityCheckRepository;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;
    @Autowired
    private ModelMapper modelMapper;

    public BaseResponse createUpdate(InterchangeabilityRequest param) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        PqcDttdInterchangeabilityCheck check = modelMapper.map(param.getData(), PqcDttdInterchangeabilityCheck.class);
        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.INTERCHANGEABILITY,check.getCheckPerson(),pqcWorkOrder, check.getConclude(), check.getNote());
        }

        check = pqcInterchangeabilityCheckRepository.save(check);
        response.setId(check.getId());
        return response;
    }

    public BaseResponse removeById(Long id) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        pqcInterchangeabilityCheckRepository.removeById(id);
        response.setResult(result);
        return response;
    }


    public InterchangeabilityResponse detail(Long id) {
        Validator.Result result = Validator.Result.OK;
        InterchangeabilityResponse response = new InterchangeabilityResponse();
        response.setResult(result);
        PqcDttdInterchangeabilityCheck check = pqcInterchangeabilityCheckRepository.findById(id).get();
        InterchangeabilityCheckDTO checkDTO = modelMapper.map(check, InterchangeabilityCheckDTO.class);
        response.setDetail(checkDTO);
        return response;
    }
}
