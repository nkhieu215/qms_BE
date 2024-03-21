package com.fn.qms.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.config.DataCache;
import com.fn.qms.dto.StepCheckDTO;
import com.fn.qms.dto.WoDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.BaseRequest;
import com.fn.qms.rest.ProductionStepRequest;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.WoCreateDTO;
import com.fn.qms.planning.model.UserWorkOrder;
import com.fn.qms.rest.PqcWorkOrderResponse;
import com.fn.qms.rest.bean.WorkOder;
import com.fn.sap.modelsbak.Citt1;


@Service
public class WoService {

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    PqcStoreCheckRepository pqcStoreCheckRepository;

    @Autowired
    PqcBomWorkOrderRepository reBomWorkOrderRepository;

    @Autowired
    PqcWorkOrderViewRepository pqcWorkOrderViewRepository;

    @Autowired
    PqcWorkOrderStepStatusRepository orderStepStatusRepository;

    @Autowired
    PqcWorkOrderStepViewRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PqcWorkOrderResponse pqcCreateUpdateWo(WoCreateDTO dto) {
        Validator.Result result = Validator.Result.OK;
        PqcWorkOrderResponse response = new PqcWorkOrderResponse();
        PqcWorkOrder wo = modelMapper.map(dto.getData(), PqcWorkOrder.class);
        WorkOder data = dto.getData();
        wo.setStatus(Constant.STATUS_CREATE);
        wo.setProductionName(data.getProductName());
        wo.setBomVersion(data.getBomVersion());
        wo.setProductionCode(data.getProductCode());
        wo.setWorkOrderId(data.getWoId());
        wo.setPlaningWorkOrderCode(data.getProductOrder());
        wo.setLotNumber(data.getLotNumber());
        wo.setBranchName(data.getBranchName());
        wo.setGroupName(data.getGroupName());
        wo.setQuantityPlan(data.getQuantityPlan());
        wo.setProfileCode(data.getProfileCode());
        wo.setProfileName(data.getProfileName());
        wo.setProfileId(data.getProfileId());
        wo.setSapWo(data.getSapWo());
        wo.setUDocURL(data.getUdocURL());
        wo.setUDocURL2(data.getUdocURL2());
        wo.setStartTime(data.getStartDate());
        wo.setEndTime(data.getEndDate());
        pqcWorkOrderRepository.save(wo);

        if (dto.getBomversion() != null && !dto.getBomversion().isEmpty()) {
            PqcBomWorkorder bomWorkorder;
            for (Citt1 citt1 : dto.getBomversion()) {
                bomWorkorder = new PqcBomWorkorder();

                bomWorkorder.setBomQuantity(citt1.getUQuantity() + "");
                bomWorkorder.setItemCode(citt1.getUItemCode());
                bomWorkorder.setItemName(citt1.getUItemName());
                bomWorkorder.setPartNumber(citt1.getUPartNumber());
                bomWorkorder.setQuantity(citt1.getUQuantity() + "");
                bomWorkorder.setVendor(citt1.getUVendor());
                bomWorkorder.setVersion(citt1.getUVersions());
                bomWorkorder.setWorkOrderId(wo.getId());
                bomWorkorder.setWorkOrderQuantity(wo.getQuantityPlan());
                bomWorkorder.setWorkOrderId(wo.getId());

                reBomWorkOrderRepository.save(bomWorkorder);
            }
        }

        if (dto.getLstUserDetail() != null && !dto.getLstUserDetail().isEmpty()) {
            PqcWorkOrderStepStatus step;
            for (UserWorkOrder userWorkOrder : dto.getLstUserDetail()) {
                if(Utils.isNull(userWorkOrder.getUserName()))
                    continue;

                step = new PqcWorkOrderStepStatus();
                step.setStatus(Constant.WAIT);
                step.setUserId(userWorkOrder.getUserName());
                step.setPqcWorkOrder(wo.getId());
                step.setStep(userWorkOrder.getStageCode());
                step.setPosition(Long.parseLong(DataCache.getSettingByCodeName(userWorkOrder.getStageCode()).getKey()));

                orderStepStatusRepository.save(step);
            }
        }
        response.setResult(result);
        return response;
    }


    /**
     * lay danh sach kiem tra
     *
     * @param id
     * @return
     */
    public PqcWorkOrderResponse getLstCheckByWo(Long id) {
        Validator.Result result = Validator.Result.OK;
        PqcWorkOrderResponse response = new PqcWorkOrderResponse();
        List<PqcWorkOrderStepStatus> lst = orderStepStatusRepository.getStepCheckByWo(id);
        List<StepCheckDTO> lstStep = Arrays.asList(modelMapper.map(lst, StepCheckDTO[].class));
        response.setLstCheck(lstStep);
        response.setResult(result);
        return response;
    }


    /**
     * lay danh sach kiem tra
     *
     * @param param
     * @return
     */
    public PqcWorkOrderResponse getLstCheckStep(ProductionStepRequest param, String userId) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Validator.Result result = Validator.Result.OK;
        PqcWorkOrderResponse response = new PqcWorkOrderResponse();
        int page = param.getPage() - 1;
        String name = Utils.isNull(param.getName()) ? null : param.getName().trim();
        String code = Utils.isNull(param.getCode()) ? null : param.getCode().trim();
        String lot = Utils.isNull(param.getLot()) ? null : param.getLot().trim();
        String sap = Utils.isNull(param.getSap()) ? null : param.getSap().trim();
        String woCode = Utils.isNull(param.getWoCode()) ? null : param.getWoCode().trim();
        String status =Utils.isNull(param.getStatus()) ? null : param.getStatus().trim();
        String groupName =Utils.isNull(param.getGroupName()) ? null : param.getGroupName().trim();
        String branchName =Utils.isNull(param.getBranchName()) ? null : param.getBranchName().trim();

        Date start = Utils.isNull(param.getStartDate()) ? null : DateUtils.convertStringToDate(param.getStartDate() + " 00:00:00", DateUtils.CURRENT_TIME);
        Date end = Utils.isNull(param.getEndDate()) ? null : DateUtils.convertStringToDate(param.getEndDate() + " 23:59:59", DateUtils.CURRENT_TIME);
        AppLog.info("page: " + page + " | size :" + param.getSize());
        Page<PqcWorkOrderViewStep> lstView;
        List<WoDTO> lstStep;
        if(Utils.isNull(param.getStep())){
            Page<PqcWorkOrderView> views =  pqcWorkOrderViewRepository.findListByName(name, code, lot, start, end, sap, woCode,status, groupName, branchName, PageRequest.of(page, param.getSize()));
            lstStep = Arrays.asList(mapper.convertValue(views.getContent(), WoDTO[].class));
            response.setTotal(views.getTotalPages());
        }else{
            lstView = repository.findListByStep(name, code, lot, param.getStep(), userId, start, end, sap, woCode,status, PageRequest.of(page, param.getSize()));
            lstStep = Arrays.asList(mapper.convertValue(lstView.getContent(), WoDTO[].class));
            response.setTotal(lstView.getTotalPages());
        }

        // check total sap
        if(!lstStep.isEmpty()){
            for (WoDTO wo : lstStep) {
                List<Object[]> obj = pqcStoreCheckRepository.getTotalStoreByWoId(wo.getId());
                if(obj != null && !obj.isEmpty()){
//                    AppLog.info("Total ::" + obj.get(0)[0]);
                    wo.setTotal(obj.get(0)[0] == null ? "0": obj.get(0)[0]+"");
//                    AppLog.info("Total SAP ::" +obj.get(0)[1]);
                    wo.setTotalSap(obj.get(0)[1] == null ? "0": obj.get(0)[1]+"");
                }
            }

        }

        response.setLstOrder(lstStep);


        return response;
    }

    public PqcWorkOrderResponse getStatusWoStepUser(BaseRequest param, String username) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Validator.Result result = Validator.Result.OK;
        PqcWorkOrderResponse response = new PqcWorkOrderResponse();
        List<PqcWorkOrderViewStep>  lstView = repository.findStepByUserAndWo(param.getId(), username,param.getStep());
        List<WoDTO> lstStep = Arrays.asList(mapper.convertValue(lstView, WoDTO[].class));
        response.setLstOrder(lstStep);
        return response;
    }


    public void cancelProcessCheckWo(Long woId,String userName){
        PqcWorkOrder pqcWorkOrder = pqcWorkOrderRepository.findById(woId).get();
        if(pqcWorkOrder != null){
            pqcWorkOrder.setStatus(Constant.CANCEL);
            pqcWorkOrderRepository.save(pqcWorkOrder);

            // update status
            List<PqcWorkOrderStepStatus> lstWoStatus=  orderStepStatusRepository.getStepCheckByWo(woId);
            if(lstWoStatus != null && !lstWoStatus.isEmpty()){
                for (PqcWorkOrderStepStatus pqcWorkOrderStepStatus: lstWoStatus) {
                    pqcWorkOrderStepStatus.setStatus(Constant.CANCEL);
                    orderStepStatusRepository.save(pqcWorkOrderStepStatus);
                }
            }
        }
    }
}
