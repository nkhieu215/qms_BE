package com.fn.qms.command;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.dto.ErrorDTO;
import com.fn.qms.dto.KeyValueDTO;
import com.fn.qms.dto.MachineResDTO;
import com.fn.qms.models.Error;
import com.fn.qms.models.PqcFixErr;
import com.fn.qms.repository.ErrorRepository;
import com.fn.qms.repository.PqcFixErrorRepository;
import com.fn.qms.rest.*;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import com.fn.scada.dto.*;
import com.fn.scada.service.ScadaService;
import com.fn.scada.service.UrlScadaConstant;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.MappingContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class ScadaGetMachine implements Command {

    @Autowired
    private ScadaService scadaService;

    @Autowired
    ErrorRepository errorRepository;

    @Autowired
    PqcFixErrorRepository pqcFixErrorRepository;

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

        // get detail wo
        ScadaAssetsRequest input = new ScadaAssetsRequest();
        input.setEntityId(param.getWoId());
        input.setType("ASSET");
        String json = scadaService.getByTypeReturnJson(input, UrlScadaConstant.SCADA_GET_DETAIL_WO);
        if (!Utils.isNull(json)) {
            json = json.replace("\\", "");
            json = json.replace(":\"[{\"", ":[{\"");
            json = json.replace("]\"}", "]}");
            json = json.replace("\"Error_Detail\":\"\"", "\"Error_Detail\":[]");

            AppLog.info("SCADA:: " + json);

            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                StageByWoId stageLst = mapper.readValue(json, StageByWoId.class);

                Map<String, MachineResDTO> lstResponse = new HashMap<>();
                if (stageLst != null ) {
                    ArrayList<StageMachine> lstStageMachineHis = stageLst.getHisListStage() != null ? stageLst.getListStage().get(0).getValue() : new ArrayList<>();
                    ArrayList<StageMachine> lstStageMachine = stageLst.getListStage() != null ? stageLst.getHisListStage().get(0).getValue() : new ArrayList<>();
                    lstStageMachine.addAll(lstStageMachineHis);

                    // lay danh sach cac may
                    MachineResDTO machineResDTO;
                    for (StageMachine machine : lstStageMachine) {
                       int numberInput = machine.getNumberOfInput();
                       int numberOutput = machine.getNumberOfOutput();
                        machineResDTO = new MachineResDTO();
                        AppLog.info(machine.getMachineName());
                        if(lstResponse.get(machine.getMachineName()) != null){
                            machineResDTO.setNumberInput(numberInput + lstResponse.get(machine.getMachineName()).getNumberInput());
                            machineResDTO.setNumberOutput(numberOutput + lstResponse.get(machine.getMachineName()).getNumberOutput());
                            machineResDTO.setName(machine.getMachineName());
                            Map<String, Object> errorInMap =lstResponse.get(machine.getMachineName()).getErrorLst();
                            Map<String, Object> errormap = getMapError(machine.getErrorDetailHmi(), machine.getErrorDetail());

                            errorInMap.forEach((id, name) -> {
                                System.out.println("Key : " + id + " value : " + name);
                                if(errormap.get(id) != null){
                                    long total = Long.parseLong(errormap.get(id).toString()) + Long.parseLong(name.toString());
                                    errormap.put(id,total+"");
                                }else{
                                    errormap.put(id,name);
                                }
                            });

                            machineResDTO.setErrorLst(errormap);
                        }else {
                            machineResDTO.setNumberInput(numberInput);
                            machineResDTO.setNumberOutput(numberOutput);
                            machineResDTO.setErrorLst(getMapError(machine.getErrorDetailHmi(), machine.getErrorDetail()));
                        }

                        lstResponse.put(machine.getMachineName(),machineResDTO);
                    }
                }
//
                List<Error> lstError = errorRepository.findAll();
                Map<String, Object> mapErr = new HashMap<>();
                for (Error err : lstError) {
                    mapErr.put(err.getName(), err.getLabel());
                }



                lstResponse.forEach((key, value) -> {
                    Map<String,Object> mapErrName = new HashMap<>();
                    List<KeyValueDTO> lstErrorTotal = new ArrayList<>();
                    value.getErrorLst().forEach((errorKey, err)->{
                        KeyValueDTO errVA;
                        if(mapErr.get(errorKey) == null){
                            mapErrName.put(errorKey +"",err);
                            errVA =  new KeyValueDTO(errorKey+"", err +"");
                        }else{
                            mapErrName.put( mapErr.get(errorKey).toString() + " ("+errorKey+"" + ")",err);
                            errVA =  new KeyValueDTO( mapErr.get(errorKey).toString() + " ("+errorKey+""+ ")",err +"");
                        }
                        lstErrorTotal.add(errVA);
                    });
                    lstResponse.get(key).setErrorExcel(lstErrorTotal);
                    lstResponse.get(key).setErrorLst(mapErrName);
                });
                res.setLstMachine(lstResponse);


            } catch (Exception e) {
                AppLog.error(e);
            }

        } else {
            result = new SimpleResult(ResponseCode.WO_INVALID.getDesc(), false, ResponseCode.WO_INVALID.getErrorCode());
        }
        response.setObj(res);
        context.setResult(result);
        return !result.isOk();
    }

    
    private Map<String, Object> getMapError(Object errorHMI , ArrayList<ErrorDetail> errorDetail){
        Map<String, Object> mapError;
        if(errorHMI != null && !ObjectUtils.isEmpty(errorHMI)){
            ObjectMapper oMapper = new ObjectMapper();

            mapError = oMapper.convertValue(errorHMI, Map.class);
            long errorbyname;
            for (ErrorDetail error: errorDetail ) {
                errorbyname = 0;
                if(mapError.get(error.getErrKey()) != null){
                    errorbyname = Long.parseLong(error.getValue()) + Long.parseLong(mapError.get(error.getErrKey()).toString());
                }
                mapError.put(error.getErrKey(),errorbyname+"");
            }
        }else{
            mapError = new HashMap<>();
            for (ErrorDetail error:    errorDetail ) {
                mapError.put(error.getErrKey(),error.getValue() + "");
            }
        }
        return mapError;
    }
}
