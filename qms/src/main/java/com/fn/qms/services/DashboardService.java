package com.fn.qms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.*;
import com.fn.qms.rest.service.IqcElectCompErrResponse;
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

import javax.persistence.criteria.CriteriaBuilder;
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
    @Autowired
    PqcQualityRepository pqcQualityRepository;
    @Autowired
    PqcPhotoelectricRepository pqcPhotoelectricRepository;
    @Autowired
    PqcPhotoelectricProductRepository pqcPhotoelectricProductRepository;

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
    public DashboardResponse getSumOfErrors(){
        DashboardResponse dashboardResponse = new DashboardResponse();
        //? Lấy danh sách lỗi
        List<Object[]> errList = this.iqcElectCompErrRepository.getIqcElectCompErrList();
        List<IqcElectCompErrResponse> errResponseList = new ArrayList<>();
        for (Object[] item : errList){
            IqcElectCompErrResponse response = new IqcElectCompErrResponse();
            response.setErrName((String) item[1]);
            response.setQuantity((Integer) item[0]);
            response.setCheckingQuantity((Integer) item[2]);
            errResponseList.add(response);
        }
        dashboardResponse.setIqcElectCompErrsList(errResponseList);
        //?Lấy danh sách Iqc theo điều kiện tìm kiếm
        List<IqcElectCompDashResponse> iqcElectCompDashResponseList = new ArrayList<>();
        List<Object[]> iqcElectronicComponents = this.electronicComponentRepository.getListIqcElectronicComponentByConditions();
        for (Object[] item : iqcElectronicComponents){
            IqcElectCompDashResponse data = new IqcElectCompDashResponse();
            data.setOrigin((String) item[0]);
            data.setPoQuantity((String) item[1]);
            data.setStatus((String)item[2]);
            data.setCheckingQuantity((Integer) item[3]);
            iqcElectCompDashResponseList.add(data);
        }
        dashboardResponse.setIqcElectCompDashList(iqcElectCompDashResponseList);
        //? pqc_store_check
        List<Object[]> objects = this.pqcStoreCheckRepository.getListPqcStoreCheck();
        List<PqcStoreCheckResponse> pqcStoreCheckResponseList = new ArrayList<>();
        for(Object[] item : objects){
            PqcStoreCheckResponse response = new PqcStoreCheckResponse();
            response.setId((Integer) item[0]);
            response.setWorkOrderId((String) item[1]);
            response.setQuantityStore((String) item[2]);
            response.setConclude((String) item[3]);
            pqcStoreCheckResponseList.add(response);
        }
        dashboardResponse.setPqcStoreCheckList(pqcStoreCheckResponseList);
        //? đếm số lượng lệnh sản xuất  trạng thái Wait
        dashboardResponse.setCountWorkOrderWaitStatus(this.pqcWorkOrderRepository.countWorkOrderWaitStatus());
        //? đếm số lượng biên bản kiểm tra ở trạng thái Wait_approve
        dashboardResponse.setCountIqcWaitApproveStatus(this.electronicComponentRepository.countIqcWaitApproveStatus());
        //? pqc quality- Đánh giá chất lượng
        List<Object> pqcQualities = this.pqcQualityRepository.getPqcQualityConclude();
        List<PqcQuantityDashResponse> pqcQuantityDashResponseList = new ArrayList<>();
        for (Object item :pqcQualities){
            PqcQuantityDashResponse response = new PqcQuantityDashResponse();
            response.setConclude((String) item);
            pqcQuantityDashResponseList.add(response);
        }
        dashboardResponse.setPqcQuantityDashResponseList(pqcQuantityDashResponseList);
        //? pqc photoelectric
        List<Object[]> pqcPhotoElectList = this.pqcPhotoelectricRepository.getPqcPhotoElectList();
        List<PqcPhotoElectDashResponse> pqcPhotoElectDashResponses = new ArrayList<>();
        for(Object[] item: pqcPhotoElectList){
            PqcPhotoElectDashResponse response = new PqcPhotoElectDashResponse();
            response.setQuantity((String) item[0]);
            response.setConclude((String) item[1]);
            pqcPhotoElectDashResponses.add(response);
        }
        dashboardResponse.setPqcPhotoElectDashResponseList(pqcPhotoElectDashResponses);
        //? pqc photoelectric product
        List<Object[]> pqcPhotoElecProductList = this.pqcPhotoelectricProductRepository.getPqcPhotoElectList();
        List<PqcPhotoElectProductDashResponse> pqcPhotoElectDashProductResponses = new ArrayList<>();
        for(Object[] item: pqcPhotoElecProductList){
            PqcPhotoElectProductDashResponse response = new PqcPhotoElectProductDashResponse();
            response.setQuantity((String) item[0]);
            response.setConclude((String) item[1]);
            pqcPhotoElectDashProductResponses.add(response);
        }
        dashboardResponse.setPqcPhotoElectProductDashResponseList(pqcPhotoElectDashProductResponses);
        return dashboardResponse;
    }
    //☺ test api
    public List<Object> PqcStoreCheckDashboardResults(){
        List<Object> objects = this.pqcQualityRepository.getPqcQualityConclude();
        return objects;
    }
}
