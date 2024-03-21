package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;


@Service
public class PhotoelectricCheckService {

    @Autowired
    PqcPhotoelectricLkdtRepository pqcPhotoelectricLkdtRepository;

    @Autowired
    PqcPhotoelectricProductRepository pqcPhotoelectricProductRepository;

    @Autowired
    PqcPhotoelectricParamRepository pqcPhotoelectricParamRepository;

    @Autowired
    PqcPhotoelectricRepository pqcPhotoelectricRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;
    public BaseResponse createUpdate(PhotoelectricRequest param) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        PqcPhotoelectric check = modelMapper.map(param.getData(), PqcPhotoelectric.class);

        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.PHOTOELECTRIC,"",pqcWorkOrder, check.getConclude(), check.getNote());
        }


        check =  pqcPhotoelectricRepository.save(check);

        if(param.getData().getLstLkdt() != null){
            for (PqcPhotoelectricLkdtDTO lkdt:  param.getData().getLstLkdt()) {
                PqcPhotoelectricLkdt checkLkdt = modelMapper.map(lkdt, PqcPhotoelectricLkdt.class);
                checkLkdt.setPqcPhotoelectricId(check.getId());
                checkLkdt.setQuantity(lkdt.getAuditQuantity());
                pqcPhotoelectricLkdtRepository.save(checkLkdt);
            }
        }

        if(param.getData().getLstParam() != null){
            for (PqcPhotoelectricParamDTO paramDTO:  param.getData().getLstParam()) {
                PqcPhotoelectricParam checkParam = modelMapper.map(paramDTO, PqcPhotoelectricParam.class);
                checkParam.setPqcPhotoelectricId(check.getId());
                pqcPhotoelectricParamRepository.save(checkParam);
            }
        }
        response.setId(check.getId());
        return response;
    }

    public BaseResponse delete(Long id) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();

        pqcPhotoelectricRepository.deleteById(id);
        return response;
    }

    public BaseResponse deleteProd(Long id) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();

        pqcPhotoelectricProductRepository.deleteById(id);
        return response;
    }

    public PqcPhotoelectricDTO getDetail(Long id){
        PqcPhotoelectric check = pqcPhotoelectricRepository.getById(id);
        PqcPhotoelectricDTO checkDto = new PqcPhotoelectricDTO();
        if (check != null){
            Type listType = new TypeToken<List<PqcPhotoelectricLkdtDTO>>(){}.getType();
            List<PqcPhotoelectricLkdtDTO> lstlkdt = modelMapper.map(check.getLstLkdt(),listType);

            Type listTypeParam = new TypeToken<List<PqcPhotoelectricParamDTO>>(){}.getType();
            List<PqcPhotoelectricParamDTO> lstParam =   modelMapper.map(check.getLstParam(),listTypeParam);

            checkDto.setConclude(check.getConclude());
            checkDto.setId(check.getId());
            checkDto.setLot(check.getLot());
            checkDto.setLstLkdt(lstlkdt);
            checkDto.setLstParam(lstParam);
            checkDto.setNote(check.getNote());
            checkDto.setQuantity(check.getQuantity());
        }

        return checkDto;
    }

    public BaseResponse createUpdateProd(PhotoelectricProdRequest param) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        PqcPhotoelectricProduct check = modelMapper.map(param.getData(), PqcPhotoelectricProduct.class);

        if(check.getWorkOrderId()!= null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(check.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.PHOTOELECTRIC_PRODUCT,"",pqcWorkOrder, check.getConclude(), check.getNote());
        }



        check =  pqcPhotoelectricProductRepository.save(check);

        response.setId(check.getId());
        return response;
    }
}
