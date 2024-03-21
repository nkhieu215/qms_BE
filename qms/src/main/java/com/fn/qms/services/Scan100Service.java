package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.AssemblesSuccessCheckDTO;
import com.fn.qms.models.PqcAssemblesSuccessCheck;
import com.fn.qms.models.PqcDttdAssemblesError;
import com.fn.qms.models.PqcScan100;
import com.fn.qms.repository.PqcAssemblesCheckRepository;
import com.fn.qms.repository.PqcAssemblesErrorRepository;
import com.fn.qms.repository.PqcScan100Repository;
import com.fn.qms.rest.*;
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
        return response;
    }
}
