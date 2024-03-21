package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.AssemblesErrorDTO;
import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.rest.AssemblesCheckResponse;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AssemblesCheckService {
    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    PqcAssemblesCheckRepository pqcAssemblesCheckRepository;

    @Autowired
    PqcAssemblesErrorRepository pqcDttdAssemblesError;

    @Autowired
    private ModelMapper modelMapper;

    public AssemblesCheckResponse checkCreateUpdate(AssemblesRequest param) {
        Validator.Result result = Validator.Result.OK;
        AssemblesCheckResponse response = new AssemblesCheckResponse();
        PqcAssemblesSuccessCheck check = modelMapper.map(param.getData(), PqcAssemblesSuccessCheck.class);

        if(check.getWorkOrderId() != null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.ASSEMBLES,check.getCheckPerson(),pqcWorkOrder, check.getConclude(), check.getNote());
        }
        pqcAssemblesCheckRepository.save(check);
        response.setIdCheck(check.getId());
        return response;
    }

    public AssemblesCheckResponse removeByType(Long id) {
        Validator.Result result = Validator.Result.OK;
        AssemblesCheckResponse response = new AssemblesCheckResponse();
        pqcAssemblesCheckRepository.deleteById(id);

        return response;
    }

    public AssemblesCheckResponse addError(AssemblesErrorRequest data) {
        Validator.Result result = Validator.Result.OK;
        AssemblesCheckResponse response = new AssemblesCheckResponse();
        response.setResult(result);

        PqcDttdAssemblesError check = modelMapper.map(data.getData(), PqcDttdAssemblesError.class);
        check.setDttdType("ASSEMBLES");
        check=  pqcDttdAssemblesError.save(check);
        response.setId(check.getId());
        return response;
    }

    public AssemblesCheckResponse removeError(Long id) {
        Validator.Result result = Validator.Result.OK;
        AssemblesCheckResponse response = new AssemblesCheckResponse();
        response.setResult(result);

        pqcDttdAssemblesError.deleteAssError(id);
        return response;
    }

    public AssemblesCheckResponse detail(Long id) {
        Validator.Result result = Validator.Result.OK;
        AssemblesCheckResponse response = new AssemblesCheckResponse();
        response.setResult(result);

        PqcAssemblesSuccessCheck check = pqcAssemblesCheckRepository.findById(id).get();
        AssemblesSuccessCheckDTO checkDTO = modelMapper.map(check, AssemblesSuccessCheckDTO.class);
        response.setDetail(checkDTO);
        return response;
    }
}
