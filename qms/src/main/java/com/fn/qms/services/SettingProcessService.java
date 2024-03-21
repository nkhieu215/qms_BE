package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.AqlTemplateDTO;
import com.fn.qms.dto.SettingProcessDTO;
import com.fn.qms.models.AqlTemplate;
import com.fn.qms.models.SettingProcess;
import com.fn.qms.repository.AqlTemplateRepository;
import com.fn.qms.repository.SettingProcessRepository;
import com.fn.qms.rest.AqlTemplateResponse;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.SettingProcessResponse;
import com.fn.qms.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SettingProcessService {

    @Autowired
    SettingProcessRepository settingProcessRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BaseResponse createEdit(SettingProcessDTO dto) {

        Validator.Result result = Validator.Result.OK;
        AqlTemplateResponse response = new AqlTemplateResponse();
        SettingProcess template = modelMapper.map(dto, SettingProcess.class);
        if(template.getId()!=null){
            SettingProcess aqlTemplate =  settingProcessRepository.getById(template.getId());
            template.setCreatedAt(aqlTemplate.getCreatedAt());
        }
        settingProcessRepository.save(template);
        response.setId(template.getId());
        response.setResult(result);

        return response;
    }


    public SettingProcessResponse getList(SettingProcessDTO dto) {
        Validator.Result result = Validator.Result.OK;
        SettingProcessResponse response = new SettingProcessResponse();
        int page = dto.getPage() - 1;
        Page<SettingProcess> lstView = settingProcessRepository.findList(dto.getName(), dto.getCode(), PageRequest.of(page, dto.getSize()));
        List<SettingProcessDTO> lstTemplate = ObjectMapperUtils.mapAll(lstView.getContent(), SettingProcessDTO.class);
        response.setTotal(lstView.getTotalPages());
        response.setLstSettingProcess(lstTemplate);
        response.setResult(result);
        return response;
    }


    public BaseResponse remove(Long id) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        settingProcessRepository.deleteById(id);
        response.setResult(result);
        return response;
    }
}
