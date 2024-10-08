package com.fn.qms.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.Request;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.*;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.ErrorMachineResponse;
import com.fn.qms.rest.ReportErrorRequest;
import com.fn.qms.rest.ReportErrorResponse;
import com.fn.qms.rest.ScadaRequest;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.service.base.ScadaServiceBase;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.ObjectMapperUtils;
import com.fn.qms.utils.Utils;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@Validated
@RequestMapping("/report")
public class ReportController extends BaseController {
    @Autowired
    private ApplicationContext context;

    @Autowired
    ScadaServiceBase scadaServiceBase;

    @Autowired
    ElectronicComponentRepository repository;
    @Autowired
    PqcWoHistoryRepository pqcWoHistoryRepository;
    @Autowired
    ReportAllErrorRepository reportAllRepository;

    @Autowired
    TinCheckSerialRepository tinCheckSerial;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    private ModelMapper modelMapper;


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
    PqcStoreErrorRepository storeErrRepository;

    @Autowired
    PqcWorkOrderRepository woRepo;

    @Autowired
    PqcStorePackingRepository packingRepo;

    @Autowired
    PqcStoreConfusedRepository storeConfusedRepository;

    @Autowired
    PqcStoreErrorRepository pqcStoreErrorRepository;
    @Autowired
    PqcStoreExternalInspectionRepository pqcStoreExternalInspectionRepository;
    @Autowired
    PqcStoreElectricRepository pqcStoreElectricRepository;
    @Autowired
    PqcStoreSafeRepository pqcStoreSafeRepository;
    @Autowired
    PqcStoreSizeRepository pqcStoreSizeRepository;
    @Autowired
    PqcStoreConfusedRepository pqcStoreConfusedRepository;
    @Autowired
    PqcStoreStructRepository pqcStoreStructRepository;
    @Autowired
    PqcQualityCheckRepository pqcQualityCheckRepository;
    @Autowired
    PqcStorePackingRepository pqcStorePackingRepository;
    @Autowired
    PqcBomWorkOrderRepository pqcBomWorkOrderRepository;
    @Autowired
    PqcDrawNVLCheckRepository pqcDrawNVLCheckRepository;
    @Autowired
    PqcScan100Repository pqcScan100Repository;
    @Autowired
    PqcErrorListRepository pqcErrorListRepository;

    @Autowired
    PqcPhotoelectricRepository pqcPhotoelectricRepository;
    @Autowired
    IqcElectCompErrRepository iqcElectCompErrRepository;
    @Autowired
    IqcAuditResultItemRepository iqcAuditResultItemRepository;

    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @PostMapping("/iqc-report/{id}")
    public void reportCheckParameter(Authentication authen, HttpServletRequest requestClient, HttpServletResponse response, @PathVariable(required = false, name = "id") Long id) {
        IqcElectronicComponent iqcElectronicComponent = repository.getById(id);
        try {
            File file = ResourceUtils.getFile("classpath:report/template/iqc_electronic_report.xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"iqc_electronic_report.xlsx\"");
            InputStream is = new FileInputStream(file);
            Context context = new Context();
            context.putVar("lkdt", iqcElectronicComponent.getResultLkdt());
            context.putVar("data", iqcElectronicComponent);
            context.putVar("lstErr", iqcElectronicComponent.getResultError());

            Type listType = new TypeToken<List<IqcAuditResultParameterDTO>>() {
            }.getType();
            List<IqcAuditResultParameterDTO> iqc = modelMapper.map(iqcElectronicComponent.getResultParam(), listType);
            mapper.writeValueAsString(iqc);
            AppLog.info(mapper.writeValueAsString(iqcElectronicComponent.getResultParam()));
            context.putVar("data2", iqc);


            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            response.flushBuffer();
            is.close();
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }

    @PostMapping("/iqc-report-nvl/{id}")
    public void reportCheckNvl(Authentication authen, HttpServletRequest requestClient, HttpServletResponse response, @PathVariable(required = false, name = "id") Long id,@RequestBody List<ErrorListDTO>request) {
        IqcElectronicComponent iqcElectronicComponent = repository.getById(id);
        List<IqcAuditResultItem> list = this.iqcAuditResultItemRepository.findAllByIqcElecCompId((int) (long)  id);
        System.out.println("check id : "+ id);
        try {
            File file = ResourceUtils.getFile("classpath:report/template/iqc_electronic_report_nvl_new.xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"iqc_electronic_report.xlsx\"");
            InputStream is = new FileInputStream(file);
            Context context = new Context();
            //context.putVar("lstErr", iqcElectronicComponent.getResultError());
            context.putVar("lstErr", request);
            context.putVar("data3", list);
            context.putVar("data", iqcElectronicComponent);

            AppLog.info(mapper.writeValueAsString(iqcElectronicComponent.getResultNvls()));
            context.putVar("data2", iqcElectronicComponent.getResultNvls());


            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            response.flushBuffer();
            is.close();
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }

    @PostMapping("/iqc-report-btp/{id}")
    public void reportCheckBtp(Authentication authen, HttpServletRequest requestClient, HttpServletResponse response, @PathVariable(required = false, name = "id") Long id,@RequestBody List<ErrorListDTO>request) {
        IqcElectronicComponent iqcElectronicComponent = repository.getById(id);
        List<IqcAuditResultItem> list = this.iqcAuditResultItemRepository.findAllByIqcElecCompId((int) (long)  id);
        try {
            File file = ResourceUtils.getFile("classpath:report/template/iqc_electronic_report_btp_new.xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"iqc_electronic_report.xlsx\"");
            InputStream is = new FileInputStream(file);
            Context context = new Context();
//            context.putVar("lstErr", iqcElectronicComponent.getResultError());
            context.putVar("lstErr", request);
            context.putVar("data", iqcElectronicComponent);
            context.putVar("data4", list);
            AppLog.info(mapper.writeValueAsString(iqcElectronicComponent.getResultNvls()));
            context.putVar("data2", iqcElectronicComponent.getResultLkdt());
            context.putVar("data3", iqcElectronicComponent.getResultParam());


            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            response.flushBuffer();
            is.close();
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }

    @PostMapping("/pqc-report-by-wo/{id}")
    public void pqcReportByWo(Authentication authen, HttpServletRequest requestClient, HttpServletResponse response, @PathVariable(required = false, name = "id") Long id) {
        PqcWorkOrder wo = pqcWorkOrderRepository.getById(id);

        try {
            File file = ResourceUtils.getFile("classpath:report/template/pqc_export.xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"pqc_export.xlsx\"");
            InputStream is = new FileInputStream(file);
            Context context = new Context();
//			context.putVar("lstErr", iqcElectronicComponent.getResultError());
            wo.setCreatedDateStr(DateUtils.convertToDateString(wo.getCreatedAt(), DateUtils.DATE_WITH_DASH2));
            context.putVar("data", wo);
            context.putVar("lstTin", wo.getLstTin());
            context.putVar("lstChecktin", tinCheckSerial.lstTinCheckByWorkOrder(id));
            context.putVar("lstmount", wo.getLstMount());
            context.putVar("lstAssembles", wo.getLstAssembles());
            context.putVar("lstQcCheck", pqcQualityCheckRepository.getListByWoId(id));

            context.putVar("lstSolder", wo.getLstSolder());
            context.putVar("lstInterchangeability", wo.getLstInter());
            context.putVar("lstBomCheck", pqcBomWorkOrderRepository.getListByWoId(id));

            List<PqcDrawTestNvl> lstDraw = pqcDrawNVLCheckRepository.getListByWoId(id);
            if (lstDraw != null) {
                for (PqcDrawTestNvl test : lstDraw) {
                    if (test.getDrawNvlCheck() != null)
                        test.getDrawNvlCheck().setCreatedAtStr(DateUtils.convertToDateString(test.getDrawNvlCheck().getCreatedAt(), DateUtils.DATE_WITH_DASH2));
                }
            }
            context.putVar("lstCheckNvl", lstDraw);
            context.putVar("lstCheckNvl100", pqcScan100Repository.getListByWoId(id, 1));
            context.putVar("lstCheckNvl100Fail", pqcScan100Repository.getListByWoId(id, 0));

            List<PqcWorkOrderApproveHist> lstHisApprove = pqcWoHistoryRepository.getListByWoId(id);
            if (lstHisApprove != null && !lstHisApprove.isEmpty())
                context.putVar("note", lstHisApprove.get(0).getNote());
            else
                context.putVar("note", "");


            // scada error

            ErrorMachineResponse errorMachineResponse =   scadaError(id, requestClient);
            List<ScadaErrorDTO> lstError = new ArrayList<>();
            if(errorMachineResponse != null && errorMachineResponse.getLstMachine()!= null &&!errorMachineResponse.getLstMachine().isEmpty()){
                ScadaErrorDTO scadaErrorDTO;
                for (MachineResDTO machineResDTO: errorMachineResponse.getLstMachine().values() ) {
                    for (KeyValueDTO dto: machineResDTO.getErrorExcel() ) {
                        scadaErrorDTO = new ScadaErrorDTO();
                        scadaErrorDTO.setName(machineResDTO.getName());
                        scadaErrorDTO.setTotalError(dto.getValue());
                        scadaErrorDTO.setErrorName(dto.getType());
                        lstError.add(scadaErrorDTO);
                    }
                }
            }
            context.putVar("scadaError",  lstError);


            context.putVar("lstFixError", wo.getLstFixErr());
            List<PqcPhotoelectricProduct> lstPhotoelectricsProduct = wo.getLstPhotoelectricsProduct();
            if (wo.getLstPhotoelectricsProduct() != null) {
                for (PqcPhotoelectricProduct phProd :
                        lstPhotoelectricsProduct) {
                    phProd.setCreatedAtStr(DateUtils.convertToDateString(phProd.getCreatedAt(), DateUtils.DATE_WITH_DASH2));
                }
            }
            context.putVar("lstPhotoelectricProduct", lstPhotoelectricsProduct);
            context.putVar("lstPhotoelectric", wo.getLstPhotoelectrics());
            if (wo.getLstPhotoelectrics() != null) {
                List<PqcPhotoelectricLkdt> lstlkdt = new ArrayList<>();
                List<PqcPhotoelectricParam> lstParam = new ArrayList<>();
                for (PqcPhotoelectric btp : wo.getLstPhotoelectrics()) {
                    lstlkdt.addAll(btp.getLstLkdt());
                    lstParam.addAll(btp.getLstParam());
                }
                context.putVar("lstPhoLkdt", lstlkdt);
                context.putVar("lstPhoParam", lstParam);
            }

            List<PqcStoreCheck> lstStoreCheck = pqcStoreCheckRepository.getListCheckStoreByWo(id);
            if (lstStoreCheck != null) {
                context.putVar("lstStoreCheck", lstStoreCheck);
                List<Long> lstIdCheck = new ArrayList<>();
                for (PqcStoreCheck check : lstStoreCheck) {
                    lstIdCheck.add(check.getId());
                }
                List<PqcStoreConfused> lstConfused = storeConfusedRepository.getListByWoId(id);
                context.putVar("lstConfused", lstConfused);
                List<PqcStoreErr> lstPqcStoreErrs = pqcStoreErrorRepository.getByListStoreCheck(lstIdCheck);
                context.putVar("lstPqcStoreErrs", lstPqcStoreErrs);
                List<PqcStoreExternalInspection> lstExternalInspections = pqcStoreExternalInspectionRepository.getListExternalInspectionByWorkOrderId(id);
                context.putVar("lstExternalInspections", lstExternalInspections);
                List<PqcStorePow> lsPows = pqcStoreElectricRepository.getListCheckElectricByWoId(id);
                context.putVar("lsPows", lsPows);
                List<PqcStoreSafe> lsPqcStoreSafes = pqcStoreSafeRepository.getListCheckSafeByWorkOrderId(id);
                context.putVar("lsPqcStoreSafes", lsPqcStoreSafes);
                List<PqcStoreSize> lsSizes = pqcStoreSizeRepository.getListCheckSizeByWorkOrderId(id);
                context.putVar("lsSizes", lsSizes);
                List<PqcStoreConfused> lstConfuseds = pqcStoreConfusedRepository.getListByWoId(id);
                context.putVar("lstConfuseds", lstConfuseds);
                List<PqcStoreStructure> pqcStoreStructures = pqcStoreStructRepository.getListCheckStructByWorkOrderId(id);
                context.putVar("pqcStoreStructures", pqcStoreStructures);

                List<PqcQualityCheck> lstQcCheck = pqcQualityCheckRepository.getListByWoId(id);
                context.putVar("lstQcCheck", lstQcCheck);

                List<PqcStorePacking> lstPacking = pqcStorePackingRepository.getListCheckPackingByStoreId(id);
                context.putVar("lstPack", lstPacking);
            }
            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            response.flushBuffer();
            is.close();
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }


    @PostMapping("/report-error/{type}")
    public ReportErrorResponse pqcReportError(HttpServletResponse response, @RequestBody ReportErrorRequest param, @PathVariable(required = false, name = "type") String type) {
        ReportErrorResponse reportErrorResponse = new ReportErrorResponse();
        Validator.Result result = Validator.Result.OK;

        if ("SHOW".equals(type)) {
            int page = param.getPage() - 1;
            int size = param.getSize();
            Page<Object[]> reportErrorAlls = reportAllRepository.reportErrorNative(param.getName(), param.getCode(), param.getGrErr(), param.getErr(), param.getWoCode(), param.getStartDate(), param.getEndDate(), param.getGroupName(), param.getBranchName(), PageRequest.of(page, size));
            if (reportErrorAlls.hasNext()) {
                List<ReportErrorAllDTO> lstError = getObject(reportErrorAlls.getContent());
                reportErrorResponse.setTotal(reportErrorAlls.getTotalPages());
                reportErrorResponse.setReportError(lstError);
            }
        } else {
            try {
                File file = ResourceUtils.getFile("classpath:report/template/bao_cao_loi_san_xuat.xlsx");
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=\"bao_cao_loi_san_xuat.xlsx\"");
                InputStream is = new FileInputStream(file);
                Context context = new Context();

                List<Object[]> reportErrorAlls = reportAllRepository.reportAllError(param.getName(), param.getCode(), param.getGrErr(), param.getErr(), param.getWoCode(), param.getStartDate(), param.getEndDate());
                List<ReportErrorAllDTO> rest = getObject(reportErrorAlls);
                reportErrorResponse.setReportError(rest);
                context.putVar("data", rest);
                JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
                response.flushBuffer();
                is.close();
            } catch (Exception exception) {

            }
        }

        reportErrorResponse.setResult(result);
        return reportErrorResponse;
    }

    private List<ReportErrorAllDTO> getObject(List<Object[]> reportErrorAlls) {
        List<ReportErrorAllDTO> lstError = new ArrayList<>();

        ReportErrorAllDTO obj;
        for (Object[] objResult : reportErrorAlls) {
            obj = new ReportErrorAllDTO();
            obj.setId((Integer) objResult[0]);
            obj.setWorkOrderId((String) objResult[1]);
            obj.setProductionCode((String) objResult[2]);
            obj.setPlaningWorkOrderCode((String) objResult[3]);
            obj.setPurchaseOrderCode((String) objResult[4]);
            obj.setBomVersion((String) objResult[5]);
            obj.setCreatedAt((Date) objResult[6]);
            obj.setUpdatedAt((Date) objResult[7]);
            obj.setCreatedBy((String) objResult[8]);
            obj.setProductionName((String) objResult[9]);
            obj.setLotNumber((String) objResult[10]);
            obj.setQuantityPlan((String) objResult[11]);
            obj.setGroupName((String) objResult[12]);
            obj.setBranchName((String) objResult[13]);
            obj.setProfileName((String) objResult[14]);
            obj.setProfileCode((String) objResult[15]);
            obj.setSapWo((String) objResult[16]);
            obj.setDocUrl((String) objResult[17]);
            obj.setDocUrl2((String) objResult[18]);
            obj.setStartTime((String) objResult[19]);
            obj.setEndTime((String) objResult[20]);
            obj.setDt((String) objResult[21]);
            obj.setDateCreate((Date) objResult[22]);
            obj.setErrGroup((String) objResult[23]);
            obj.setErrName((String) objResult[24]);
            obj.setQuantity((String) objResult[25]);
            obj.setRatio((String) objResult[26]);
            obj.setDttdType((String) objResult[27]);
            obj.setSerialNo((String) objResult[28]);
            obj.setProcessName((String) objResult[29]);

            lstError.add(obj);
        }

        return lstError;
    }

    private ErrorMachineResponse scadaError(Long woId, HttpServletRequest requestClient) {
        Request request = new Request();
        ScadaRequest param = new ScadaRequest();
        param.setType("MACHINE");
        param.setId(woId);
        request.setBaseRequest(param);
        request = setBase(request, param);
        UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
       return scadaServiceBase.getMachineByWo(request, user, context);
    }
}
