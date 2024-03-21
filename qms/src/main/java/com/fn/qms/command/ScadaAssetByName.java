package com.fn.qms.command;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.repository.PqcFixErrorRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.*;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import com.fn.scada.dto.ScadaAssetsData;
import com.fn.scada.service.ScadaService;
import com.fn.scada.service.UrlScadaConstant;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScadaAssetByName implements Command {


    @Autowired
    ScadaService scadaService;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;
    @Override
    public boolean execute(Context cntxt) throws Exception {
        AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
        ProcessContext context = (ProcessContext) cntxt;
        Response response = context.getResponse();
        Validator.Result result = Validator.Result.OK;
        ApplicationContext ctx = context.getContext();
        Request request = context.getRequest();
        ErrorMachineResponse res = new ErrorMachineResponse();

        ScadaRequest param = (ScadaRequest) request.getBaseRequest();
        PqcWorkOrder wo =  pqcWorkOrderRepository.findById(param.getId()).get();
        if(wo != null){
            String key = wo.getWorkOrderId() + "-"+ wo.getLotNumber();
            AppLog.info("KEY :: " + key);
            ScadaAssetsRequest input = new ScadaAssetsRequest();
            input.setEntityId(key);

            String json =  scadaService.getByTypeReturnJson(input, UrlScadaConstant.SCADA_GET_ASSET_BY_NAME);
            if(!Utils.isNull(json)){
                ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                try {
                    AppLog.info(json);
                    ScadaAssetsData scadaAssetsData = mapper.readValue(json, ScadaAssetsData.class);
                    AppLog.info(scadaAssetsData.getId().getId());
                    param.setWoId(scadaAssetsData.getId().getId());
                } catch (Exception e) {
                    AppLog.error(e);
                }
            }else{
                result =  new SimpleResult(ResponseCode.WO_INVALID.getDesc(),false,ResponseCode.WO_INVALID.getErrorCode());
            }
        }else{
            result =  new SimpleResult(ResponseCode.WO_INVALID.getDesc(),false,ResponseCode.WO_INVALID.getErrorCode());
        }

        context.setResult(result);
        return !result.isOk();
    }

}
