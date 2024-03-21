package com.fn.qms.services;

import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fn.qms.base.validator.SimpleResult;
import com.fn.qms.bean.ResponseCode;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.KeyValueDTO;
import com.fn.qms.dto.ReportStoreViewDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.rest.pqc.ReportStoreReponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import com.fn.sap.dto.ItemInfor;
import com.fn.sap.dto.MaterialInfor;
import com.fn.sap.dto.PartNumberInfor;
import com.fn.sap.dto.SendSapRequest;
import com.fn.sap.service.SapConnector;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.PackingDTO;
import com.fn.qms.dto.StoreCreateDTO;
import com.fn.qms.planning.rest.PlanningUpdateStoreInput;
import com.fn.qms.planning.service.PlanningService;
import com.fn.qms.rest.bean.StoreCheck;
import com.fn.qms.rest.bean.StoreCheckElectronic;
import com.fn.qms.rest.bean.StoreCheckErr;
import com.fn.qms.rest.bean.StoreCheckExternalInspection;
import com.fn.qms.rest.bean.StoreCheckSafe;
import com.fn.qms.rest.bean.StoreCheckSize;
import com.fn.qms.rest.bean.StoreCheckStructure;
import com.fn.qms.rest.bean.StorecheckConfused;

@Service
public class StoreCheckService {

    @Autowired
    PqcStoreCheckRepository pqcStoreCheckRepository;

    @Autowired
    PqcStoreElectricRepository storeElectricRepo;


    @Autowired
    PqcStoreExternalInspectionRepository storeExternalRepo;

    @Autowired
    PqcStoreSizeRepository storeSizeRepo;

    @Autowired
    PqcStoreSafeRepository storeSafeRepo;

    @Autowired
    PqcStoreConfusedRepository confusedRepository;

    @Autowired
    PqcStoreStructRepository pqcStoreStructRepository;

    @Autowired
    PqcStoreErrorRepository storeErrRepository;

    @Autowired
    PqcWorkOrderRepository woRepo;

    @Autowired
    PqcStorePackingRepository packingRepo;

    @Autowired
    SapConnector sapConnector;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    public StoreCheckResponse pqcCreateStoreCheck(StoreCreateDTO dto) {
        Validator.Result result = Validator.Result.OK;
        StoreCheckResponse response = new StoreCheckResponse();

        PqcStoreCheck storeCheck = modelMapper.map(dto.getData(), PqcStoreCheck.class);
        storeCheck.setStatusApproveSap(Constant.DRAFF);

        if(dto.getData().getId() == null){
            // send to planing
          String idPlaning =   sendToPlaning(storeCheck.getWorkOrderId(),storeCheck.getQuatityStore(), "create", null);
          storeCheck.setIdApprovePlaning(idPlaning);
        }else{
            // update planing
            PqcStoreCheck store =  pqcStoreCheckRepository.findById(storeCheck.getId()).get();
            storeCheck.setStatusApproveSap(store.getStatusApproveSap());
            storeCheck.setIdApprovePlaning(store.getIdApprovePlaning());
            storeCheck.setCreatedAt(store.getCreatedAt());
            String action = "";
            if(Utils.isNull(store.getIdApprovePlaning())){
                action = "create";
            }else{
                action = "update";
            }
            String storeId =   sendToPlaning(storeCheck.getWorkOrderId(),storeCheck.getQuatityStore(),action, store.getIdApprovePlaning() );
            storeCheck.setIdApprovePlaning(storeId);
        }

        if(storeCheck.getId() == null){
            PqcWorkOrder pqcWorkOrder =pqcWorkOrderRepository.findById(storeCheck.getWorkOrderId()).get();
            Utils.buildPqcWarning(Constant.APPROVE_STORE,"",pqcWorkOrder, storeCheck.getConclude(), storeCheck.getNote());
        }

        pqcStoreCheckRepository.save(storeCheck);
        response.setId(storeCheck.getId());
        return response;
    }

    /**
     * lay danh sach check store
     *
     * @param id
     * @return
     */
    public StoreCheckResponse getListCheckStoreByWoId(Long id) {
        Validator.Result result = Validator.Result.OK;
        StoreCheckResponse response = new StoreCheckResponse();
        List<PqcStoreCheck> lstStoreCheck = pqcStoreCheckRepository.getListCheckStoreByWo(id);
        List<StoreCheck> lstStoreCheckDTO = Arrays.asList(modelMapper.map(lstStoreCheck, StoreCheck[].class));
        response.setLstCheck(lstStoreCheckDTO);
        response.setResult(result);
        return response;
    }

    public StoreCheckResponse checkElectricStoreCheck(StoreCreateDTO dto) {
        StoreCheckResponse response = new StoreCheckResponse();
        Validator.Result result = Validator.Result.OK;

        response.setResult(result);
        return response;
    }

    public StoreCheckResponse getLstCheckByType(Long id, String type) {

        StoreCheckResponse response = new StoreCheckResponse();
        Validator.Result result = Validator.Result.OK;

        switch (type) {
            case "ELEC":
                List<PqcStorePow> lstElec = storeElectricRepo.getListCheckElectricByStoreId(id);
                List<StoreCheckElectronic> lstElecRes = Arrays.asList(modelMapper.map(lstElec, StoreCheckElectronic[].class));
                response.setLstElectric(lstElecRes);
                break;

            case "EXTER":

                List<PqcStoreExternalInspection> lstExternal = storeExternalRepo.getListExternalInspectionByStoreId(id);
                List<StoreCheckExternalInspection> lstEx = Arrays.asList(modelMapper.map(lstExternal, StoreCheckExternalInspection[].class));
                response.setLsCheckExternalInspections(lstEx);
                break;

            case "SIZE":

                List<PqcStoreSize> lstSize = storeSizeRepo.getListCheckSizeByStoreId(id);
                List<StoreCheckSize> lstSizeRes = Arrays.asList(modelMapper.map(lstSize, StoreCheckSize[].class));
                response.setLstSize(lstSizeRes);
                break;

            case "SAFE":
                List<PqcStoreSafe> lstStoreSafe = storeSafeRepo.getListCheckSafeByStoreId(id);
                List<StoreCheckSafe> lstStoreSafeRes = Arrays.asList(modelMapper.map(lstStoreSafe, StoreCheckSafe[].class));
                response.setLstStoreSafe(lstStoreSafeRes);
                break;

            case "CONFUSED":
                List<PqcStoreConfused> lstConfuse = confusedRepository.getListCheckConfusedByStoreId(id);
                List<StorecheckConfused> lstExConfuesdResponse = Arrays.asList(modelMapper.map(lstConfuse, StorecheckConfused[].class));
                response.setLstConfuseds(lstExConfuesdResponse);
                break;

            case "STRUCTURE":
                List<PqcStoreStructure> lstStoreStruct = pqcStoreStructRepository.getListCheckStructByStoreId(id);
                List<StoreCheckStructure> lstConfuused = Arrays.asList(modelMapper.map(lstStoreStruct, StoreCheckStructure[].class));
                response.setLstStructures(lstConfuused);
                break;

            case "ERROR":
                List<PqcStoreErr> lstError = storeErrRepository.getListCheckErryByStoreId(id);
                List<StoreCheckErr> lstErrResponse = Arrays.asList(modelMapper.map(lstError, StoreCheckErr[].class));
                response.setLstCheckErrs(lstErrResponse);
                break;

            default:
                break;
        }

        return response;
    }

    public StoreCheckResponse saveCheckStore(String type, StoreCreateDTO dto, UserDetailsImpl user) {
        StoreCheckResponse response = new StoreCheckResponse();
        Validator.Result result = Validator.Result.OK;

        Long storeId ;
        switch (type) {
            case "ELEC":

                PqcStorePow powCheck = modelMapper.map(dto.getDataCheck().getElectric(), PqcStorePow.class);
                powCheck.setCheckPerson(user.getUsername());
                storeElectricRepo.save(powCheck);
                storeId = powCheck.getStoreCheckId();
                response.setId(powCheck.getId());
                break;

            case "EXTER":
                if(dto.getDataCheck().getLstexternalInspections() != null && !dto.getDataCheck().getLstexternalInspections().isEmpty()){
                    for (StoreCheckExternalInspection ex:  dto.getDataCheck().getLstexternalInspections() ) {
                        PqcStoreExternalInspection externalInspection = modelMapper.map(ex, PqcStoreExternalInspection.class);
                        externalInspection.setCheckPerson(user.getUsername());
                        storeExternalRepo.save(externalInspection);
                    }
                }
                if(dto.getDataCheck().getExternalInspections() != null){
                    PqcStoreExternalInspection externalInspection = modelMapper.map(dto.getDataCheck().getExternalInspections(), PqcStoreExternalInspection.class);
                    externalInspection.setCheckPerson(user.getUsername());
                    storeExternalRepo.save(externalInspection);
                    response.setId(externalInspection.getId());
                }

                break;

            case "SIZE":
                PqcStoreSize storeSize = modelMapper.map(dto.getDataCheck().getSize(), PqcStoreSize.class);
                storeSize.setCheckPerson(user.getUsername());
                storeSizeRepo.save(storeSize);
                response.setId(storeSize.getId());
                break;

            case "SAFE":
                PqcStoreSafe safe = modelMapper.map(dto.getDataCheck().getSafe(), PqcStoreSafe.class);
                safe.setCheckPerson(user.getUsername());
                storeSafeRepo.save(safe);
                response.setId(safe.getId());
                break;

            case "CONFUSED":
                PqcStoreConfused confued = modelMapper.map(dto.getDataCheck().getConfused(), PqcStoreConfused.class);
                confued.setCheckPerson(user.getUsername());
                confusedRepository.save(confued);
                response.setId(confued.getId());
                break;

            case "STRUCTURE":

                PqcStoreStructure struct = modelMapper.map(dto.getDataCheck().getStructure(), PqcStoreStructure.class);
                struct.setCheckPerson(user.getUsername());
                pqcStoreStructRepository.save(struct);
                response.setId(struct.getId());
                break;

            case "ERROR":

                PqcStoreErr storeerr = modelMapper.map(dto.getDataCheck().getCheckErr(), PqcStoreErr.class);
                storeerr.setCheckPerson(user.getUsername());
                storeErrRepository.save(storeerr);
                response.setId(storeerr.getId());
                break;

            default:
                break;
        }

        // update total check


        response.setResult(result);
        return response;
    }

    public StoreCheckResponse savePacking(PackingDTO param) {
        StoreCheckResponse response = new StoreCheckResponse();
        Validator.Result result = Validator.Result.OK;

        PqcStorePacking packing = new PqcStorePacking();
        packing.setPacking(param.getPacking());
        packing.setTray(param.getTray());
        packing.setStoreCheckId(param.getStoreId());
        try {
            ObjectMapper mapper = new ObjectMapper();
            packing.setSerial(mapper.writeValueAsString(param.getLstSerial()));
        } catch (Exception e) {
        }
        packingRepo.save(packing);


        return response;
    }

    public StoreCheckResponse removeCheckStore(KeyValueDTO dto) {

        String type = dto.getType();
        Long id = dto.getId();
        Validator.Result result = Validator.Result.OK;
        StoreCheckResponse response = new StoreCheckResponse();
        switch (type) {
            case "ELEC":
                storeElectricRepo.deleteById(id);
                break;

            case "EXTER":
                storeExternalRepo.deleteById(id);
                break;

            case "SIZE":
                storeSizeRepo.deleteById(id);
                break;

            case "SAFE":
                storeSafeRepo.deleteById(id);
                break;

            case "CONFUSED":
                confusedRepository.deleteById(id);
                break;

            case "STRUCTURE":
                pqcStoreStructRepository.deleteById(id);
                break;

            case "ERROR":
                 storeErrRepository.deleteById(id);
                break;

            case "CHECK":
                PqcStoreCheck store =  pqcStoreCheckRepository.findById(id).get();
                if(store != null && !Utils.isNull(store.getIdApprovePlaning())) {
                    sendToPlaning(store.getWorkOrderId(), store.getQuatityStore(), "delete", store.getIdApprovePlaning());
                }

                pqcStoreCheckRepository.deleteById(id);

                // remove check
                storeErrRepository.deleteAllByStoreCheckId(id);
                pqcStoreStructRepository.deleteAllByStoreCheckId(id);
                confusedRepository.deleteAllByStoreCheckId(id);
                storeSafeRepo.deleteAllByStoreCheckId(id);
                storeSizeRepo.deleteAllByStoreCheckId(id);
                storeExternalRepo.deleteAllByStoreCheckId(id);
                storeElectricRepo.deleteAllByStoreCheckId(id);
                break;

            default:
                break;
        }

        response.setResult(result);
        return response;
    }


    @Autowired
    ReportStoreRepository reportStoreRepository;
    public ReportStoreReponse reportStore(ProductionStepRequest param, String username) {
        Validator.Result result = Validator.Result.OK;
        ReportStoreReponse response =  new ReportStoreReponse();
        int page = param.getPage() - 1;
        String name= Utils.isNull(param.getName()) ? null : param.getName().trim();
        String code = Utils.isNull(param.getCode()) ? null : param.getCode().trim();
        String lot = Utils.isNull(param.getLot()) ? null : param.getLot().trim();
        String sap = Utils.isNull(param.getSap())? null : param.getSap().trim();
        String woCode = Utils.isNull(param.getWoCode())? null : param.getWoCode().trim();
        String groupName = Utils.isNull(param.getGroupName())? null : param.getGroupName().trim();
        String branchName = Utils.isNull(param.getBranchName())? null : param.getBranchName().trim();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Date start = Utils.isNull(param.getStartDate())? cal.getTime()  : DateUtils.convertStringToDate(param.getStartDate() + " 00:00:00",DateUtils.CURRENT_TIME);
        Date end =Utils.isNull(param.getEndDate())? new Date()  : DateUtils.convertStringToDate(param.getEndDate() + " 23:59:59",DateUtils.CURRENT_TIME);

        if(Constant.REPORT.equalsIgnoreCase(param.getTypeRequest()) ){
            List<ReportStoreView> reportStoreViews = reportStoreRepository.reportStore(name, code, lot,start,end,sap, woCode, branchName, groupName);
            List<ReportStoreViewDTO> lst =  Arrays.asList(modelMapper.map(reportStoreViews, ReportStoreViewDTO[].class));
            response.setLstData(lst);
        }else{
            Page<ReportStoreView> reportStoreViews = reportStoreRepository.findListByName(name, code, lot,start,end,sap, woCode, branchName, groupName, PageRequest.of(page, param.getSize()));
            response.setTotal(reportStoreViews.getTotalPages());
            response.setTotalPages(reportStoreViews.getTotalPages());
            List<ReportStoreViewDTO> lst =  Arrays.asList(modelMapper.map(reportStoreViews.getContent(), ReportStoreViewDTO[].class));
            response.setLstData(lst);
        }

        response.setResult(result);
        return response;
    }

    public BaseResponse aproveStoreSap(StoreSapApproveRequest param) {
        BaseResponse response =new BaseResponse();
        Validator.Result result = Validator.Result.OK;

        PqcStoreCheck pqcStoreCheck = pqcStoreCheckRepository.findById(param.getStoreId()).get();
        if( Constant.LST_ACTION.contains(param.getAction())){
            String statusSap = "Thất bại";
            if(Constant.ACTION_APPROVE.equalsIgnoreCase(param.getAction())) {
                try{
                    // send sap
                    SendSapRequest sendSapRequest = new SendSapRequest();
                    PqcWorkOrder pqcWorkOrder = woRepo.findById(pqcStoreCheck.getWorkOrderId()).get();
                    sendSapRequest.setWoId(pqcWorkOrder.getWorkOrderId());
                    sendSapRequest.setLotNumber(pqcWorkOrder.getLotNumber());
                    sendSapRequest.setSapWo(pqcWorkOrder.getSapWo());
                    sendSapRequest.setTransactionType("REPORT");
                    sendSapRequest.setSourceDepartment(param.getDoituong());
                    sendSapRequest.setWareHouse( Utils.isNull(param.getKhoBh()) ? "" :  param.getKhoBh());
                    sendSapRequest.setNote(param.getNote());
                    sendSapRequest.setTo(Utils.isNull(param.getKhonhap()) ? "": param.getKhonhap());
                    ArrayList<ItemInfor> itemInfors = new ArrayList<>();
                    ItemInfor itemInfor = new ItemInfor();
                    itemInfor.setItemCode(pqcWorkOrder.getProductionCode());
                    ArrayList<PartNumberInfor> partNumberInfors = new ArrayList<>();
                    PartNumberInfor partNumberInfor = new PartNumberInfor();
                    ArrayList<MaterialInfor> materialInfors = new ArrayList<>();
                    MaterialInfor materialInfor= new MaterialInfor();
                    materialInfor.setMaterialQuantity(param.getQuantityStoreSap());
                    materialInfor.setMaterialId("");
                    materialInfors.add(materialInfor);
                    partNumberInfor.setMaterialInfor(materialInfors);
                    partNumberInfor.setColor(Utils.isNull(pqcStoreCheck.getColorCode()) ? "" : pqcStoreCheck.getColorCode());
                    partNumberInfor.setPartNumber("");
                    partNumberInfor.setLotNumber("");
                    partNumberInfors.add(partNumberInfor);
                    itemInfor.setPartNumberInfor(partNumberInfors);
                    itemInfors.add(itemInfor);
                    sendSapRequest.setItemInfor(itemInfors);
                    sendSapRequest.setCreatedAt(param.getDateApproveSap());
                    sendSapRequest.setNumOfReq("");
                    sendSapRequest.setProfileId("");
                    sendSapRequest.setProfileCode("");

                    String res  = sapConnector.sendApproveStore(sendSapRequest);
                    if("ok".equalsIgnoreCase(res)){
                        statusSap = "Thành công";
                    }

                    long totalSap = Utils.isNull(pqcStoreCheck.getQuantityStoreSap()) ? Long.parseLong(param.getQuantityStoreSap()) : Long.parseLong(pqcStoreCheck.getQuantityStoreSap()) +  Long.parseLong(param.getQuantityStoreSap()) ;
                    pqcStoreCheck.setQuantityStoreSap(totalSap + "");
                }catch (Exception ex){
                    AppLog.error(ex);
                }
            }

            // update db
            pqcStoreCheck.setStatusSap(statusSap);
            pqcStoreCheck.setNoteApprove(param.getNote());
            pqcStoreCheck.setStatusApproveSap(param.getAction());
            pqcStoreCheck.setUpdatedAt(new Date());

            ObjectMapper mapper  = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            try{
                List<StoreSapApproveRequest> lstStore;
                if(Utils.isNull(pqcStoreCheck.getHisString())){
                    lstStore = new ArrayList<>();
                }else{
                     lstStore =new ArrayList<>(Arrays.asList(mapper.readValue(pqcStoreCheck.getHisString(),StoreSapApproveRequest[].class)));
                }
                lstStore.add(param);
                param.setStatusSap(statusSap);
                String hisString = mapper.writeValueAsString(lstStore);
                pqcStoreCheck.setHisString(hisString);
            }catch (Exception ex){
                AppLog.error(ex);
            }
            pqcStoreCheck.setDateApproveSap(param.getDateApproveSap());
            pqcStoreCheckRepository.save(pqcStoreCheck);
        }

        response.setResult(result);
        return response;
    }

    public BaseResponse sendApproveStoreSap(BaseRequest param, String username) {
        BaseResponse response =new BaseResponse();
        Validator.Result result = Validator.Result.OK;

        Long id = param.getId();
        PqcStoreCheck pqcStoreCheck = pqcStoreCheckRepository.findById(id).get();
        if(pqcStoreCheck != null &&
                Constant.LST_SEND_APPROVE.contains(pqcStoreCheck.getStatusApproveSap()) &&
                pqcStoreCheck.getCheckPerson().equalsIgnoreCase(username) ){
            pqcStoreCheck.setStatusApproveSap(Constant.ACTION_WAIT_APPROVE);
            pqcStoreCheckRepository.save(pqcStoreCheck);
        }else{
            result = new SimpleResult(ResponseCode.STORE_SEND_APPROVE_INVALID.getDesc(), false, ResponseCode.STORE_SEND_APPROVE_INVALID.getErrorCode());
        }

        response.setResult(result);
        return response;
    }

    public StoreCheckResponse getStoreInfo(Long id) {
        StoreCheckResponse storeCheckResponse = new StoreCheckResponse();
        Validator.Result result = Validator.Result.OK;
        PqcStoreCheck pqcStoreCheck =  pqcStoreCheckRepository.findById(id).get();
        if(pqcStoreCheck != null){
            StoreCheck storeCheck = modelMapper.map(pqcStoreCheck,StoreCheck.class);
            storeCheckResponse.setStoreCheck(storeCheck);
        }
        storeCheckResponse.setResult(result);
        return storeCheckResponse;
    }

    public String sendToPlaning(Long woId,String quantity, String action, String updateId ){
        PqcWorkOrder wo = woRepo.getOne(woId);
        PlanningUpdateStoreInput input = new PlanningUpdateStoreInput();
        input.setWo(wo.getWorkOrderId());
        input.setQuantity(quantity);
        input.setMode(action);
        input.setUpdateId(updateId);
        String idPlaning = PlanningService.getInstall().updateStoreWo(input);
        return idPlaning.replace("SUCCESS:","");
    }

    private void updateCheckTotal(Long storeId){

    }
}

