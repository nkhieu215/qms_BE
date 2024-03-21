package com.fn.qms.synscada.schedule;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.models.Error;
import com.fn.qms.models.ErrorGroup;
import com.fn.qms.models.ErrorLstGr;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fn.qms.planning.service.UrlPlanningConstant;
import com.fn.qms.repository.ErrorGroupRepository;
import com.fn.qms.repository.ErrorLstGrRepository;
import com.fn.qms.repository.ErrorRepository;
import com.fn.qms.rest.*;
import com.fn.scada.service.ScadaService;
import com.fn.qms.utils.AppLog;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.scada.dto.ScadaKeyValue;
import com.fn.scada.dto.ScadaObjectValue;
import com.fn.scada.service.UrlScadaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SynErrGroupScada {

    @Autowired
    ScadaService scadaService;

    @Autowired
    ErrorGroupRepository errorGroupRepository;

    @Autowired
    ErrorLstGrRepository errorLstGrRepository;

    @Autowired
    ErrorRepository errorRepository;

    @Scheduled(cron = "${schedule.sync.scada.sync.error}", zone = "Asia/Saigon")
    public void syncErrorGroupScada() {
        AppLog.info("sync");
        scadaService.getErrorLstScada();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ScadaAssetsRequest input = new ScadaAssetsRequest();
        input.setPage(0);
        input.setPageSize(500);
        input.setSortOrder("DESC");
        input.setSortProperty("createdTime");
        input.setType("group_error");
        ScadaResponse errorGr = scadaService.getByType(input, UrlScadaConstant.SCADA_GET_ASSETS_CONFIG);

        if (errorGr != null && errorGr.getData() != null && !errorGr.getData().isEmpty()) {
            ErrorGroup errorGroup;
            for (ScadaAssetsData asset : errorGr.getData()) {
                // check by id
                errorGroup = errorGroupRepository.findByIdStage(asset.getId().getId());
                if (errorGroup == null) {
                    errorGroup = new ErrorGroup();
                    errorGroup.setIdGr(asset.getId().getId());
                }
                errorGroup.setLabel(asset.getLabel());
                errorGroup.setType(asset.getType());
                errorGroup.setName(asset.getName());
                errorGroupRepository.save(errorGroup);
            }
        }


        // get err list
        ScadaAssetsRequest inputError = new ScadaAssetsRequest();
        inputError.setPage(0);
        inputError.setPageSize(50000);
        inputError.setSortOrder("DESC");
        inputError.setSortProperty("createdTime");
        inputError.setType("error");
        ScadaResponse errorlst = scadaService.getByType(inputError, UrlScadaConstant.SCADA_GET_ASSETS_CONFIG);

        if (errorlst != null && errorlst.getData() != null && !errorlst.getData().isEmpty()) {
            Error error;
            List<Error> lstErr = new ArrayList<>();
            for (ScadaAssetsData asset : errorlst.getData()) {
                // check by id
                Error err = errorRepository.findByIdStage(asset.getId().getId());
                if (err == null) {
                    err = new Error();
                    err.setIdError(asset.getId().getId());
                }
                err.setLabel(asset.getLabel());
                err.setType(asset.getType());
                err.setName(asset.getName());

                errorRepository.save(err);
                lstErr.add(err);
            }


            // check group by error get gr
            // delete all
            errorLstGrRepository.deleteAll();
            for (Error err : lstErr) {
                ScadaAssetsRequest inputErrGrbyErr = new ScadaAssetsRequest();
                inputErrGrbyErr.setType("ASSET");
                inputErrGrbyErr.setEntityId(err.getIdError());
                List<ScadaKeyValue> lstKey = scadaService.getGroupByError(inputErrGrbyErr, UrlScadaConstant.SCADA_GET_ERR_GR_CONFIG);
                List<ErrorGroup> lstGroup = new ArrayList<>();
                for (ScadaKeyValue val : lstKey) {
                    if ("group_error".equalsIgnoreCase(val.getKey())) {
                        try{
                            String jsonValue =   mapper.writeValueAsString(val.getValue());
                            List<ScadaObjectValue> lstERr = mapper.readValue(jsonValue, new TypeReference<List<ScadaObjectValue>>(){});
                            if (lstERr != null && !lstERr.isEmpty())
                                for (ScadaObjectValue vaf : lstERr) {
                                    String idState = vaf.getEntityId().getId();
                                    ErrorGroup errGr = errorGroupRepository.findByIdStage(idState);
                                    if(errGr != null){
                                        ErrorLstGr errorLstGr  = new ErrorLstGr();
                                        errorLstGr.setIdErrGr(errGr.getId());
                                        errorLstGr.setIdError(err.getId());
                                        errorLstGrRepository.save(errorLstGr);
                                    }
                                }
                        }catch (Exception ex){
                            AppLog.error(ex);
                        }
                    }
                }

                errorRepository.save(err);
            }

        }

    }
}
