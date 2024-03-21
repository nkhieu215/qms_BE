package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PhotoelectricProdRequest;
import com.fn.qms.rest.PhotoelectricRequest;
import com.fn.qms.rest.QcCheckRequest;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class QcCheckService {

    @Autowired
    PqcQualityRepository pqcQualityRepository;

    @Autowired
    PqcQualityCheckRepository pqcQualityCheckRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;
    public BaseResponse createUpdate(QcCheckRequest param) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        PqcQuality check = modelMapper.map(param.getData(), PqcQuality.class);

        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.QC_CHECK,"",pqcWorkOrder, check.getConclude(), check.getNote());
        }

        check =  pqcQualityRepository.save(check);

        if(param.getData().getLstCheck() != null){
            for (PqcQualityCheckDTO checkDTO:  param.getData().getLstCheck()) {
                PqcQualityCheck checkLkdt = modelMapper.map(checkDTO, PqcQualityCheck.class);
                checkLkdt.setQualityId(check.getId());
                checkLkdt.setWorkOrderId(check.getWorkOrderId());
                pqcQualityCheckRepository.save(checkLkdt);
            }
        }
        response.setId(check.getId());
        return response;
    }

    public BaseResponse delete(Long id) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();

        pqcQualityRepository.deleteById(id);
        return response;
    }

    public PqcQualityDTO getDetail(Long id) {
        PqcQuality quality = pqcQualityRepository.getById(id);
        List<PqcQualityCheck> lst = pqcQualityCheckRepository.getListByCheckId(id);
        quality.setLstCheck(lst);
        return  modelMapper.map(quality, PqcQualityDTO.class);
    }

}
