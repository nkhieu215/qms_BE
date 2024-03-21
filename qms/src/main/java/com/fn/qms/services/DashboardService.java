package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import com.fn.sap.models.*;
import com.fn.sap.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Service
public class DashboardService {

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    PqcQualityCheckRepository pqcQualityCheckRepository;

    @Autowired
    PqcStoreCheckRepository pqcStoreCheckRepository;

    @Autowired
    ElectronicComponentRepository electronicComponentRepository;
    @Autowired
    IqcElectCompErrRepository iqcElectCompErrRepository;

    public DashboardResponse getDashboardPqcIqc(ProductionStepRequest param) {
        String groupName = Utils.isNull(param.getGroupName()) ? null : param.getGroupName().trim().toUpperCase();
        String  branchName = Utils.isNull(param.getBranchName()) ? null : param.getBranchName().trim().toUpperCase();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date start = Utils.isNull(param.getStartDate()) ?  calendar.getTime() : DateUtils.convertStringToDate(param.getStartDate() + " 00:00:00", DateUtils.CURRENT_TIME);
        Date end = Utils.isNull(param.getEndDate()) ? new Date() : DateUtils.convertStringToDate(param.getEndDate() + " 23:59:59", DateUtils.CURRENT_TIME);

        DashboardResponse respo = new DashboardResponse();
        respo.setResult(Validator.Result.OK);
        List<PqcWorkOrder> lstApprove = pqcWorkOrderRepository.report(start, end, groupName, branchName);

        // thong tin san xuat va tinh trang
        long totalQuantity =0;
        long waitApprove = 0;
        List<Long> idWo = new ArrayList<>();
        for (PqcWorkOrder workOrder: lstApprove) {
            if(Constant.ACTION_WAIT_APPROVE.equalsIgnoreCase(workOrder.getStatus()))
                waitApprove++;
            idWo.add(workOrder.getId());
            totalQuantity = totalQuantity + (Utils.isNull(workOrder.getQuantityPlan()) ? 0 : (long)Double.parseDouble(workOrder.getQuantityPlan().trim().replace(",","")));
        }
        respo.setPqcWaitApprove(waitApprove);
        respo.setQuantityDemanded(totalQuantity);

        // danh gia chat luong san pham
        List<Object[]> lstTotalCheck = pqcQualityCheckRepository.reportCheckQuality(idWo);
        for (Object[] obj: lstTotalCheck) {
            if(obj != null && obj.length > 1){
                AppLog.info(obj.length + "");
                Long t = Utils.isNull(obj[0].toString()) ? 0 : (long)Double.parseDouble(obj[0].toString());
                String con = obj[1] != null ? obj[1].toString() : "";

                if(Constant.Quality.equalsIgnoreCase(con)){
                    respo.setWorkOrderQuality(t);
                }
                else if(Constant.FAIL.equalsIgnoreCase(con)){
                    respo.setWorkOrderFail(t);
                }
                else if(Constant.Concessions.equalsIgnoreCase(con)){
                    respo.setWorkOrderConcessions(t);
                }
            }

        }

        // so luong nhap kho
        List<Object[]> lstTotalStore =  pqcStoreCheckRepository.getTotalStoreByWoId(idWo);
        if(lstTotalStore != null && !lstTotalStore.isEmpty()){
            long quantityStore = (long)Double.parseDouble(lstTotalStore.get(0)[0] == null ? "0": lstTotalStore.get(0)[0]+"");
            long quantityStoreSap = (long)Double.parseDouble(lstTotalStore.get(0)[1] == null ? "0": lstTotalStore.get(0)[1]+"");
            respo.setQuantityStore(quantityStore);
            respo.setQuantityStoreSap(quantityStoreSap);
        }

        // thong ke thong tin IQC
        List<String> lstStatus = Arrays.asList(new String[] { Constant.IQC_STATUS_DRAFF, Constant.IQC_STATUS_APPROVE, Constant.IQC_STATUS_CONCESSIONS,Constant.IQC_STATUS_WAIT_APPROVE });
        List<IqcElectronicComponent> lstIqc=  electronicComponentRepository.findIqcReport(start, end,lstStatus);
        if(lstIqc != null && !lstIqc.isEmpty()){
            respo.setIqcEx(lstIqc.size());
        }

        // thong ke nha cung cap iqc
        List<Object[]> lstOrigin = electronicComponentRepository.reportByOrigin(start, end);
        if(lstOrigin != null && !lstOrigin.isEmpty()){
            respo.setIqcVendor(lstOrigin.size());
        }

        List<Object[]> lstSumStatusIqc = electronicComponentRepository.reportByStatus(start, end,lstStatus);
        if(lstSumStatusIqc != null && !lstSumStatusIqc.isEmpty()){
            long iqcQuantity = 0;
            for (Object[] obj: lstSumStatusIqc) {
                String status = obj[1]+"";
                long total = Utils.isNull(obj[0]+"") ? 0 : (long)Double.parseDouble(obj[0]+"");
                iqcQuantity = iqcQuantity + total;
                if(Constant.IQC_STATUS_APPROVE.equalsIgnoreCase(status)){
                    respo.setIqcQuality(total);
                }
                else if(Constant.IQC_STATUS_CONCESSIONS.equalsIgnoreCase(status)){
                    respo.setIqcConcessions(total);
                }
                else if(Constant.IQC_STATUS_WAIT_APPROVE.equalsIgnoreCase(status)){
                    respo.setIqcWaitApprove(total);
                }
            }
            respo.setIqcQuantity(iqcQuantity);
        }

        return respo;
    }

    public DashboardResponse getChart(ProductionStepRequest param) {
        String groupName = Utils.isNull(param.getGroupName()) ? null : param.getGroupName().trim().toUpperCase();
        String  branchName = Utils.isNull(param.getBranchName()) ? null : param.getBranchName().trim().toUpperCase();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = Utils.isNull(param.getStartDate()) ?  calendar.getTime() : DateUtils.convertStringToDate(param.getStartDate() + " 00:00:00", DateUtils.CURRENT_TIME);
        Date end = Utils.isNull(param.getEndDate()) ? new Date() : DateUtils.convertStringToDate(param.getEndDate() + " 23:59:59", DateUtils.CURRENT_TIME);


        DashboardResponse response =  new DashboardResponse();
        response.setResult(Validator.Result.OK);

        // top lỗi
        List<Object[]> lstErrorTotal = pqcWorkOrderRepository.getTotakErrorTop(start, end, groupName, branchName);
        List<KeyValueDTO> lstChartError =  new ArrayList<>();
        if(lstErrorTotal != null && !lstErrorTotal.isEmpty()){
            KeyValueDTO keyValueDTO;
            for (Object[] objects:  lstErrorTotal) {
                String name = objects[1].toString();
                String value = objects[0].toString();
                keyValueDTO= new KeyValueDTO(name,value);
                lstChartError.add(keyValueDTO);
            }
        }
        response.setLstChartError(lstChartError);

        // thong ke nhom loi
        List<Object[]> lstErrorGroupTotal = pqcWorkOrderRepository.getTotakErrorGroup(start, end, groupName, branchName);
        List<KeyValueDTO> lstChartErrorGroup =  new ArrayList<>();
        if(lstErrorGroupTotal != null && !lstErrorGroupTotal.isEmpty()){
            KeyValueDTO keyValueDTO;
            for (Object[] objects:  lstErrorGroupTotal) {
                if(objects != null){
                    String name = objects[1] + "";
                    String value = objects[0] + "";
                    keyValueDTO= new KeyValueDTO(name,value);
                    lstChartErrorGroup.add(keyValueDTO);
                }
            }
        }
        response.setLstChartErrorGroup(lstChartErrorGroup);

        // tong hop chat luong hang hoa nhap
        List<Object[]> lstIQCStatusObj =  electronicComponentRepository.reportCountStatus(start,end);
        List<KeyValueDTO> lstIQCStatus =  new ArrayList<>();
        if(lstIQCStatusObj != null && !lstIQCStatusObj.isEmpty()){
            KeyValueDTO keyValueDTO;
            for (Object[] objects:  lstIQCStatusObj) {
                String name = objects[1] + "";
                String value = objects[0] + "";
                keyValueDTO= new KeyValueDTO(name,value);
                lstIQCStatus.add(keyValueDTO);
            }
        }
        response.setLstIQCStatus(lstIQCStatus);

        return  response;
    }
    //? new api for dashboard
    //? Lấy danh sách tổng lỗi
    public DashboardResponse1 getSumOfErrors(){
        DashboardResponse1 dashboardResponse = new DashboardResponse1();
        //☺ Lấy danh sách lỗi
        List<IqcElectCompErr> errList = this.iqcElectCompErrRepository.findAll();
        dashboardResponse.setLstIqcElectCompErr(errList);
        //?Lấy danh sách Iqc theo điều kiện tìm kiếm
//        List<IqcElectronicComponent> iqcElectronicComponents = this.electronicComponentRepository.getListIqcElectronicComponentByConditions();
//        dashboardResponse.setLstIqcElectronicComponents(iqcElectronicComponents);
        return dashboardResponse;
    }
}
