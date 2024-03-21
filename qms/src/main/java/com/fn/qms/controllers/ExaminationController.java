package com.fn.qms.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fn.qms.repository.ExaminationRepository;
import com.fn.qms.rest.*;
import com.fn.qms.rest.iqc.ExaminationRequest;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.services.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fn.qms.base.validator.Validator.Result;
import com.fn.qms.bean.Request;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.ExaminationServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;

@RestController
@Validated
@RequestMapping("/examination")
public class ExaminationController extends BaseController {


    @Autowired
    private ApplicationContext context;

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    ExaminationService examinationService;

    @PostMapping("/crud")
    public BaseResponse crud(Authentication authen, HttpServletRequest requestClient,
                             @Valid @RequestBody ExaminationRequest param) {
        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
        Request request = new Request();
        request.setExaminationRequest(param);
        ExaminationResponse response = new ExaminationResponse();
        Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
            response.setResult(result);
        } else {
            // setcommon
            request = setBase(request, param);

            UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
            ExaminationServiceBase service = new ExaminationServiceBase();
            response = service.crudExamination(request, user, context);
        }
        return response;
    }

    @PostMapping("/search")
    @JsonIgnoreProperties({"id"})
    public BaseResponse searchTemplate(Authentication authen, HttpServletRequest requestClient, @RequestBody ExaminationRequest param) {
        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
        return examinationService.findTemplateByType(param.getCode(), param.getType());
    }

    @PostMapping("/crud-param")
    public BaseResponse crudParam(Authentication authen, HttpServletRequest requestClient,
                                  @Valid @RequestBody ExaminationParamRequest param) {
        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
        Request request = new Request();
        request.setExminationParam(param);
        ExaminationResponse response = new ExaminationResponse();
        Result result = null;
        result = validate(param); //param validation       
        if (!result.isOk()) {
            response.setResult(result);
        } else {
            // setcommon
            request = setBase(request, param);
            Principal principal = requestClient.getUserPrincipal();
            request.setPartnerId(principal.getName());

            ExaminationServiceBase service = new ExaminationServiceBase();
            UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
            response = service.crudExaminationParam(request, user, context);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse remove(Authentication authen, HttpServletRequest requestClient, @PathVariable("id") Long id) {

        AppLog.info(requestClient.getRequestURI() + "-" + id.toString());
        BaseResponse response = new BaseResponse();
        examinationRepository.deleteExById(id);

        return response;
    }

    @PostMapping("/copy")
    public BaseResponse copy(Authentication authen, HttpServletRequest requestClient, @RequestBody Request request) {

        AppLog.info(requestClient.getRequestURI() + "-" + request.getId().toString());
        BaseResponse response =  examinationService.copy(request.getId());

        return response;
    }
}
