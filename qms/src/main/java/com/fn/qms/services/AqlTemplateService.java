package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.*;
import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.PqcDttdTinCheck;
import com.fn.qms.models.PqcDttdTinCheckSerial;
import com.fn.qms.models.PqcWorkOrderView;
import com.fn.qms.repository.AqlTemplateRepository;
import com.fn.qms.repository.DAO.PQCWorkOrderDAO;
import com.fn.qms.repository.DAO.TinCheckDAO;
import com.fn.qms.repository.PqcTinCheckRepository;
import com.fn.qms.repository.TinCheckSerialRepository;
import com.fn.qms.rest.AqlTemplateResponse;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.TinCheckSerialResponse;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.ObjectMapperUtils;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AqlTemplateService {

    @Autowired
    AqlTemplateRepository aqlTemplateRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BaseResponse createEdit(AqlTemplateDTO dto) {

        Validator.Result result = Validator.Result.OK;
        AqlTemplateResponse response = new AqlTemplateResponse();
        AqlTemplate template = modelMapper.map(dto, AqlTemplate.class);
        if(template.getId()!=null){
            AqlTemplate aqlTemplate =  aqlTemplateRepository.getById(template.getId());
            template.setCreatedAt(aqlTemplate.getCreatedAt());
        }

        aqlTemplateRepository.save(template);
        response.setId(template.getId());
        response.setResult(result);

        return response;
    }


    public AqlTemplateResponse getList(AqlTemplateDTO dto) {
        Validator.Result result = Validator.Result.OK;
        AqlTemplateResponse response = new AqlTemplateResponse();
        int page = dto.getPage() - 1;
        Page<AqlTemplate> lstView = aqlTemplateRepository.findList(dto.getTestLevel(), dto.getAcceptanceLevel(), dto.getAllowedError(), PageRequest.of(page, dto.getSize()));

        List<AqlTemplateDTO> lstTemplate = ObjectMapperUtils.mapAll(lstView.getContent(), AqlTemplateDTO.class);

        response.setTotal(lstView.getTotalPages());
        response.setLstTemplate(lstTemplate);
        response.setResult(result);

        return response;
    }


    public BaseResponse remove(Long id) {

        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        aqlTemplateRepository.deleteTemplate(id);
        response.setResult(result);
        return response;
    }

}
