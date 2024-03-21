package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.MountCheckDTO;
import com.fn.qms.dto.PqcCriteriaQualityDTO;
import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.dto.iqc.nvl.IqcExaminationDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.bean.IqcCriteriaNvl;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@Service
public class ExaminationService {
    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    IqcAuditCritetialNvlRepository auditCritetialNvlRepository;
    @Autowired
    IqcAuditCritetialLkdtRepository auditCritetialLkdtRepository;

    @Autowired
    IqcAuditCritetialParameterRepository auditCritetialParameterRepository;

    @Autowired
    PqcCritetialQualityRepository critetialQualityRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ExaminationResponse findTemplateByType(String code, Integer type) {
        ExaminationResponse response = new ExaminationResponse();
        List<IqcExaminationType> lst = examinationRepository.searchListByCode(type, code);
        Type listType = new TypeToken<List<IqcExaminationDTO>>() {
        }.getType();
        List<IqcExaminationDTO> lstDto = modelMapper.map(lst, listType);


        // remove id
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ;
        try {
            String json = mapper.writeValueAsString(lstDto);

            String data = json.replace("id", "idTemplate");
            List<IqcExaminationDTO> lstRemove = Arrays.asList(mapper.readValue(data, IqcExaminationDTO[].class));
            response.setLstExamination(lstRemove);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setLstExamination(lstDto);
        }
        return response;
    }

    /**
     * copy mau bien ban
     *
     * @return
     */
    public BaseResponse copy(Long id) {
        BaseResponse response = new BaseResponse();
        Validator.Result result = Validator.Result.OK;
        response.setResult(result);

        IqcExaminationType examinationType = examinationRepository.findById(id).get();
        if (examinationType != null) {
            IqcExaminationType newInstance = new IqcExaminationType();
            BeanUtils.copyProperties(examinationType, newInstance);
            newInstance.setId(null);
            newInstance.setName(examinationType.getName() + "_copy");
            newInstance.setIqcAuditCriteriaParameters(null);
            newInstance.setLstAuditCriteriaLkdt(null);
            newInstance.setLstPqcCriteriaQualities(null);
            newInstance.setLstAuditCriteriaNvl(null);
            examinationRepository.save(newInstance);


            switch (examinationType.getType()) {
                case 1:
                    if (examinationType.getLstAuditCriteriaNvl() != null) {
                        IqcAuditCriteriaNvl nvl = null;
                        for (IqcAuditCriteriaNvl reNvl : examinationType.getLstAuditCriteriaNvl()) {
                            nvl = new IqcAuditCriteriaNvl();
                            BeanUtils.copyProperties(reNvl, nvl);
                            nvl.setId(null);
                            nvl.setTemplateId(newInstance.getId());
                            auditCritetialNvlRepository.save(nvl);
                        }
                    }
                    break;
                case 2:
                    if (examinationType.getLstAuditCriteriaLkdt() != null && !examinationType.getLstAuditCriteriaLkdt().isEmpty()) {
                        IqcAuditCriteriaLkdt criteriaLkdt;
                        for (IqcAuditCriteriaLkdt lkdtC : examinationType.getLstAuditCriteriaLkdt()) {

                            criteriaLkdt = new IqcAuditCriteriaLkdt();
                            BeanUtils.copyProperties(lkdtC, criteriaLkdt);
                            criteriaLkdt.setTemplateId(newInstance.getId());
                            criteriaLkdt.setId(null);
                            auditCritetialLkdtRepository.save(criteriaLkdt);
                        }
                    }

                    if (examinationType.getIqcAuditCriteriaParameters() != null && !examinationType.getIqcAuditCriteriaParameters().isEmpty()) {
                        IqcAuditCriteriaParameter iqcAuditCriteriaParameter;
                        for (IqcAuditCriteriaParameter paramlkdt : examinationType.getIqcAuditCriteriaParameters()) {
                            iqcAuditCriteriaParameter = new IqcAuditCriteriaParameter();
                            BeanUtils.copyProperties(paramlkdt, iqcAuditCriteriaParameter);
                            iqcAuditCriteriaParameter.setTemplateId(newInstance.getId());
                            iqcAuditCriteriaParameter.setId(null);
                            auditCritetialParameterRepository.save(iqcAuditCriteriaParameter);
                        }
                    }
                    break;
                case 3:
                    if (examinationType.getLstPqcCriteriaQualities() != null && !examinationType.getLstPqcCriteriaQualities().isEmpty()) {
                        PqcCriteriaQuality pqcCriteriaQuality;
                        for (PqcCriteriaQuality paramlkdt : examinationType.getLstPqcCriteriaQualities()) {
                            pqcCriteriaQuality = new PqcCriteriaQuality();
                            BeanUtils.copyProperties(paramlkdt, pqcCriteriaQuality);
                            pqcCriteriaQuality.setTemplateId(newInstance.getId());
                            pqcCriteriaQuality.setId(null);
                            critetialQualityRepository.save(pqcCriteriaQuality);
                        }
                    }
                    break;
            }
        } else {
            result = new SimpleResult("Copy err", false, "99");
            response.setResult(result);
        }

        return response;
    }
}
