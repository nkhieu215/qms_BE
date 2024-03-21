package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.dto.SolderCheckDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MountCheckService {

    @Autowired
    PqcMountCompCheckRepository pqcMountCompCheckRepository;

    @Autowired
    PqcDttdMountErrorRepository pqcDttdMountErrorRepository;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MountCheckResponse mountCheckCreateUpdate(MountRequest param) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        PqcDttdMountCompCheck check = modelMapper.map(param.getData(), PqcDttdMountCompCheck.class);

        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.MOUNT_COMPONENTS,check.getCheckPerson(),pqcWorkOrder, check.getConclude(), check.getNote());
        }



        pqcMountCompCheckRepository.save(check);
        response.setIdCheck(check.getDttdMountCompId());
        return response;
    }

    public MountCheckResponse removeByType(Long id) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        pqcMountCompCheckRepository.deleteById(id);

        return response;
    }

    public MountCheckResponse addError(MountErrorRequest data) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        response.setResult(result);

        PqcDttdMountError check = modelMapper.map(data.getData(), PqcDttdMountError.class);
        check.setDttdType("MOUNT");
        check=  pqcDttdMountErrorRepository.save(check);
        response.setId(check.getId());
        return response;
    }

    public MountCheckResponse removeError(Long id) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        response.setResult(result);

        pqcDttdMountErrorRepository.deleteById(id);
        return response;
    }

    public MountCheckResponse detail(Long id) {
        Validator.Result result = Validator.Result.OK;
        MountCheckResponse response = new MountCheckResponse();
        response.setResult(result);

        PqcDttdMountCompCheck check = pqcMountCompCheckRepository.findById(id).get();
        MountCheckDTO checkDTO = modelMapper.map(check, MountCheckDTO.class);
        response.setDetail(checkDTO);
        return response;
    }
}
