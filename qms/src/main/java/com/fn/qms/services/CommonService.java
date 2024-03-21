package com.fn.qms.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.config.DataCache;
import com.fn.qms.constant.Constant;
import com.fn.qms.controllers.ExaminationController;
import com.fn.qms.dto.*;
import com.fn.qms.dto.warning.NotiDto;
import com.fn.qms.dto.warning.PqcWarning;
import com.fn.qms.models.*;
import com.fn.qms.process.Queue;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.rest.iqc.ElectronicComponentResponse;
import com.fn.qms.utils.AppLog;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class CommonService {

    @Autowired
    PqcWorkOrderStepStatusRepository stepStatus;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    PqcTinCheckRepository pqcTinCheckRepository;

    @Autowired
    PqcAssemblesCheckRepository pqcAssemblesCheckRepository;

    @Autowired
    PqcSoderCompCheckRepository pqcSoderCompCheckRepository;
    @Autowired
    PqcMountCompCheckRepository pqcMountCompCheckRepository;

    @Autowired
    PqcPhotoelectricProductRepository pqcPhotoelectricProductRepository;
    @Autowired
    PqcPhotoelectricRepository pqcPhotoelectricRepository;
    @Autowired
    PqcStoreCheckRepository pqcStoreCheckRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ElectronicComponentRepository electronicComponentRepository;
    @Autowired
    ApproveHisRepository approveHisRepository;

    public BaseResponse updateStepStatus(Long workOrderId, String step, String userId) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        List<PqcWorkOrderStepStatus> lstCheck = stepStatus.getStepbyUserId(workOrderId, step, userId);
        if (lstCheck != null) {
            for (PqcWorkOrderStepStatus pqcWorkOrderStepStatus : lstCheck) {
                pqcWorkOrderStepStatus.setStatus(Constant.SUCCESS);
                stepStatus.save(pqcWorkOrderStepStatus);
            }

            // check status  success
            List<Object[]> lstStatus = stepStatus.getStatusByWoId(workOrderId);
            PqcWorkOrder pqcWorkOrder = pqcWorkOrderRepository.findById(workOrderId).get();
            if (lstStatus != null && lstStatus.size() == 1 && Constant.SUCCESS.equals(lstStatus.get(0)[0])) {
                if (pqcWorkOrder != null) {
                    pqcWorkOrder.setStatus(Constant.IQC_STATUS_WAIT_APPROVE);
                    pqcWorkOrderRepository.save(pqcWorkOrder);
                }
            }

            // push noti
            checkPushNoti(step, userId, workOrderId);

        }
        response.setResult(result);
        return response;
    }

    public StepStatusResponse statusUserStep(Long id) {
        Validator.Result result = Validator.Result.OK;
        StepStatusResponse response = new StepStatusResponse();
        List<PqcWorkOrderStepStatus> lstCheck = stepStatus.getStepCheckByWo(id);
        Type listType = new TypeToken<List<StepStatusDTO>>() {
        }.getType();
        List<StepStatusDTO> lstrest = modelMapper.map(lstCheck, listType);
        for (StepStatusDTO dto : lstrest) {
            Setting setting =  DataCache.getSettingByCodeName(dto.getStep());
            String name = setting != null ? setting.getName() : dto.getStep();
            dto.setChecked(setting != null ? Boolean.parseBoolean(setting.getCheckApprove()) : true );
            dto.setNameStep(name);
        }
        response.setLstStep(lstrest);
        response.setResult(result);
        return response;
    }


    public BaseResponse approveCheck(ApproveCheckRequest param, String username) {
        Validator.Result result = Validator.Result.OK;
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResult(result);
        ApproveHis approveHis = modelMapper.map(param, ApproveHis.class);
        approveHis.setUserId(username);
        approveHisRepository.save(approveHis);

        if ("IQC".equalsIgnoreCase(param.getType())) {
            IqcElectronicComponent iqcElectronicComponent = electronicComponentRepository.findById(param.getCheckId()).get();
            iqcElectronicComponent.setStatus(param.getApproveStatus());
            iqcElectronicComponent.setUpdatedAt(new Date());
            iqcElectronicComponent.setAproveBy(username);
            iqcElectronicComponent.setApproveNote(param.getNote());
            electronicComponentRepository.save(iqcElectronicComponent);
        } else if ("PQC".equalsIgnoreCase(param.getType())) {

        }

        return baseResponse;
    }

    @Autowired
    PqcDrawNvlRepository pqcDrawNvlRepository;

    @Autowired
    SettingProcessRepository settingProcessRepository;
    @Autowired
    ObjectMapper objectMapper;
    private void checkPushNoti(String step, String userId, Long woId) {
        List<String> concludeLst = new ArrayList<>();
        concludeLst.add("NHÂN NHƯỢNG");
        concludeLst.add("KHÔNG ĐẠT");

        String note = "";
        String conclude = "";
        String stepName = DataCache.getSettingByCodeName(step) != null ? DataCache.getSettingByCodeName(step).getName() : step;
        String url = Constant.URL_APP_PQC;

        boolean noti = false;

        switch (step) {
            case Constant.NVL:
                List<PqcDrawNvl> lstNoti = pqcDrawNvlRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstNoti != null && !lstNoti.isEmpty()) {
                    noti = true;
                    note = lstNoti.get(0).getNote();
                    conclude = lstNoti.get(0).getConclude();
                }
                break;
            case Constant.NVL100:
                break;
            case Constant.TIN:
                List<PqcDttdTinCheck> lstTinCheck = pqcTinCheckRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstTinCheck != null && !lstTinCheck.isEmpty()) {
                    noti = true;
                    note = lstTinCheck.get(0).getNote();
                    conclude = lstTinCheck.get(0).getConclude();
                }
                break;
            case Constant.MOUNT_COMPONENTS:
                List<PqcDttdMountCompCheck> lstmount = pqcMountCompCheckRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstmount != null && !lstmount.isEmpty()) {
                    noti = true;
                    note = lstmount.get(0).getNote();
                    conclude = lstmount.get(0).getConclude();
                }
                break;
            case Constant.SOLDER:
                List<PqcDttdSolderCheck> lstSolderChecks = pqcSoderCompCheckRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstSolderChecks != null && !lstSolderChecks.isEmpty()) {
                    noti = true;
                    note = lstSolderChecks.get(0).getNote();
                    conclude = lstSolderChecks.get(0).getConclude();
                }
                break;
            case Constant.ASSEMBLES:
                List<PqcAssemblesSuccessCheck> pqcAssemblesCheckRepositoryLstCheckNoti = pqcAssemblesCheckRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (pqcAssemblesCheckRepositoryLstCheckNoti != null && !pqcAssemblesCheckRepositoryLstCheckNoti.isEmpty()) {
                    noti = true;
                    note = pqcAssemblesCheckRepositoryLstCheckNoti.get(0).getNote();
                    conclude = pqcAssemblesCheckRepositoryLstCheckNoti.get(0).getConclude();
                }
                break;
            case Constant.PHOTOELECTRIC:
                List<PqcPhotoelectric> lsPqcPhotoelectrics = pqcPhotoelectricRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lsPqcPhotoelectrics != null && !lsPqcPhotoelectrics.isEmpty()) {
                    noti = true;
                    note = lsPqcPhotoelectrics.get(0).getNote();
                    conclude = lsPqcPhotoelectrics.get(0).getConclude();
                }
                break;
            case Constant.PHOTOELECTRIC_PRODUCT:
                List<PqcPhotoelectricProduct> lstPqcPhotoelectricProducts =   pqcPhotoelectricProductRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstPqcPhotoelectricProducts != null && !lstPqcPhotoelectricProducts.isEmpty()) {
                    noti = true;
                    note = lstPqcPhotoelectricProducts.get(0).getNote();
                    conclude = lstPqcPhotoelectricProducts.get(0).getConclude();
                }
                break;
            case Constant.FIX_ERR:
                break;
            case Constant.STORE_CHECK:
                List<PqcStoreCheck> lstStoreCheck = pqcStoreCheckRepository.getLstCheckNoti(concludeLst, woId, userId);
                if (lstStoreCheck != null && !lstStoreCheck.isEmpty()) {
                    noti = true;
                    note = lstStoreCheck.get(0).getNote();
                    conclude = lstStoreCheck.get(0).getConclude();
                }

                break;
            case Constant.QC_CHECK:
                break;

        }

        NotiConfig notiConfig = DataCache.getNoticonfig(step);
        if (notiConfig != null && noti) {
            stepName = DataCache.getSettingByCodeName(step).getName();
            ObjectMapper objectMapper = new ObjectMapper();
            PqcWorkOrder pqcWorkOrder = pqcWorkOrderRepository.findById(woId).get();
            // get step by user
            NotiDto notiDto = new NotiDto();
            notiDto.setType(notiConfig.getType());
            notiDto.setTitle(notiConfig.getTitle());
            notiDto.setTopic(notiConfig.getTopic());
            notiDto.setAppName(notiConfig.getAppName());

            PqcWarning pqcWarning = new PqcWarning();
            pqcWarning.setWo(pqcWorkOrder.getSapWo());
            pqcWarning.setNote(note);
            pqcWarning.setConclude(conclude);
            pqcWarning.setStep(stepName);
            pqcWarning.setLotnumber(pqcWorkOrder.getLotNumber());
            pqcWarning.setUrl(url);
            pqcWarning.setPoCode(pqcWorkOrder.getSapWo());
            pqcWarning.setDateStart(pqcWorkOrder.getStartTime());
            pqcWarning.setProductName(pqcWorkOrder.getProductionName());
            pqcWarning.setProductCode(pqcWorkOrder.getProductionCode());

            try {
                notiDto.setContent(objectMapper.writeValueAsString(pqcWarning));
                Queue.notiQueue.add(notiDto);
            }catch (Exception exception){

            }

        }


    }


    public SettingProcessResponse settingProcess() {
        Validator.Result result = Validator.Result.OK;
        SettingProcessResponse settingProcessResponse = new SettingProcessResponse();
        settingProcessResponse.setResult(result);
        List<SettingProcess> lstProcess = settingProcessRepository.findAll();
        try{
            List<SettingProcessDTO> settingProcessDTOS  = Arrays.asList(objectMapper.convertValue(lstProcess, SettingProcessDTO[].class));
            settingProcessResponse.setLstSettingProcess(settingProcessDTOS);
        }catch (Exception ex){
            AppLog.error(ex);
        }
        return settingProcessResponse;
    }
}
