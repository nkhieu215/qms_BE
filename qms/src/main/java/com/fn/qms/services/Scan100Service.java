package com.fn.qms.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.dto.Scan100DTO;
import com.fn.qms.dto.warning.IqcWarning;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.dto.warning.Scan100Warning;
import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcDttdAssemblesError;
import com.fn.qms.models.PqcScan100;
import com.fn.qms.process.Queue;
import com.fn.qms.repository.PqcAssemblesCheckRepository;
import com.fn.qms.repository.PqcAssemblesErrorRepository;
import com.fn.qms.repository.PqcScan100Repository;
import com.fn.qms.rest.*;
import com.fn.qms.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Scan100Service {

    @Autowired
    PqcScan100Repository pqcScan100Repository;

    @Autowired
    private ModelMapper modelMapper;

    public Scan100Response createUpdate(Scan100Request param) {
        Validator.Result result = Validator.Result.OK;
        Scan100Response response = new Scan100Response();
        PqcScan100 check = modelMapper.map(param.getData(), PqcScan100.class);
        pqcScan100Repository.save(check);
        response.setId(check.getId());
        response.setCreatedAt(check.getCreatedAt());
        response.setUpdatedAt(check.getUpdatedAt());
        return response;
    }
    public void update(Scan100Request param){
        PqcScan100 check = modelMapper.map(param.getData(), PqcScan100.class);
        PqcScan100 response = this.pqcScan100Repository.findById(check.getId()).orElse(null);
        response.setConfirm(check.getConfirm());
        pqcScan100Repository.save(response);
    }
    public void sendMessage(Scan100Warning response){
        ObjectMapper objectMapper = new ObjectMapper();
        NotiDto notiDto = new NotiDto();
        notiDto.setTopic("pqc-scan-100");
        Scan100Warning scan100DTO = new Scan100Warning();
        scan100DTO.setMachine(response.getMachine());
        scan100DTO.setStatus(response.getStatus());
        scan100DTO.setWorkOrder(response.getWorkOrder());
        try {
            notiDto.setContent(objectMapper.writeValueAsString(scan100DTO));
            Queue.notiQueue.add(notiDto);
        }catch (Exception exception){}
    }
}
