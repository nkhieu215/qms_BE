package com.fn.qms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.dto.*;
import com.fn.qms.models.PqcStoreCheck;
import com.fn.qms.repository.PqcStoreCheckRepository;
import com.fn.qms.rest.*;
import com.fn.qms.rest.pqc.ReportStoreReponse;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.DateUtils;
import com.fn.qms.utils.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fn.qms.services.StoreCheckService;
import com.fn.qms.utils.AppLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping("/store-check")
public class StoreController extends BaseController {

    @Autowired
    StoreCheckService storeCheck;

    @PostMapping("/create")
    public StoreCheckResponse tinCheckSerial(Authentication authen, HttpServletRequest requestClient,
                                             @Valid @RequestBody StoreCreateDTO param) {

        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
        StoreCheckResponse response = new StoreCheckResponse();

        response = storeCheck.pqcCreateStoreCheck(param);

        return response;
    }

    @GetMapping("/get-check-store-by-wo/{id}")
    public StoreCheckResponse getCheckStoreByWo(Authentication authen, HttpServletRequest requestClient,
                                                @PathVariable("id") Long id) {
        StoreCheckResponse response = storeCheck.getListCheckStoreByWoId(id);

        return response;
    }

    @GetMapping("/get-store-info/{id}")
    public StoreCheckResponse getStoreInfo(Authentication authen, HttpServletRequest requestClient,
                                           @PathVariable("id") Long id) {
        StoreCheckResponse response = storeCheck.getStoreInfo(id);

        return response;
    }


    @GetMapping("/get-lst-check-store-id/{id}/{type}")
    public StoreCheckResponse getLstCheckByStoreId(Authentication authen, HttpServletRequest requestClient,
                                                   @PathVariable("id") Long id, @PathVariable("type") String type) {

        StoreCheckResponse response = storeCheck.getLstCheckByType(id, type);

        return response;
    }

    @PostMapping("/save-check/{type}")
    public StoreCheckResponse getLstCheckByStoreId(Authentication authen, HttpServletRequest requestClient,
                                                   @PathVariable("type") String type, @Valid @RequestBody StoreCreateDTO param) {
        UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
        StoreCheckResponse response = storeCheck.saveCheckStore(type, param, user);
        return response;
    }

    @PostMapping("/save-packing")
    public StoreCheckResponse savePacking(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody PackingDTO param) {
        StoreCheckResponse response = storeCheck.savePacking(param);
        return response;
    }

    @PostMapping("/remove")
    public StoreCheckResponse remove(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody KeyValueDTO param) {
        StoreCheckResponse response = storeCheck.removeCheckStore(param);
        return response;
    }

    @PostMapping("/aproveStoreSap")
    public BaseResponse aproveStoreSap(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody StoreSapApproveRequest param) {
        BaseResponse response = storeCheck.aproveStoreSap(param);
        return response;
    }

    @PostMapping("/send-approve-store-sap")
    public BaseResponse sendApproveStoreSap(Authentication authen, HttpServletRequest requestClient, @Valid @RequestBody BaseRequest param) {
        UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
        BaseResponse response = storeCheck.sendApproveStoreSap(param, user.getUsername());
        return response;
    }

    @PostMapping("/report-store")
    public ReportStoreReponse reportStore(HttpServletRequest requestClient, @RequestBody ProductionStepRequest param) {
        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());
        ReportStoreReponse response = new ReportStoreReponse();
        Validator.Result result = null;
        result = validate(param); //param validation
        if (!result.isOk()) {
            response.setResult(result);
        } else {
            UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
            response = storeCheck.reportStore(param, user.getUsername());
        }
        return response;
    }


    @PostMapping("/report-store-excel")
    public void reportStore(HttpServletResponse response, HttpServletRequest requestClient, @RequestBody ProductionStepRequest param) {
        AppLog.info(requestClient.getRequestURI() + "-" + param.toString());

        UserDetailsImpl user = Utils.convertKeycloakToUserUtil(requestClient);
        ReportStoreReponse report = storeCheck.reportStore(param, user.getUsername());
        try {
            File file = ResourceUtils.getFile("classpath:report/template/bao_cao_san_xuat.xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"bao_cao_san_xuat.xlsx\"");
            InputStream is = new FileInputStream(file);
            Context context = new Context();
            context.putVar("report", report.getLstData());

            JxlsHelper.getInstance().processTemplate(is, response.getOutputStream(), context);
            response.flushBuffer();
            is.close();
        } catch (Exception e) {
            logger.error("Error:", e);
        }
    }


    @Autowired
    PqcStoreCheckRepository pqcStoreCheckRepository;

    @GetMapping("/sync-approve")
    public BaseResponse callSap() {

        BaseResponse response = new BaseResponse();
        List<PqcStoreCheck> lstCheck = pqcStoreCheckRepository.getLstStoreWaitApprove();
        try {
            for (PqcStoreCheck check : lstCheck) {
               String idplaning = storeCheck.sendToPlaning(check.getWorkOrderId(), check.getQuatityStore(),"create",null);
                check.setIdApprovePlaning(idplaning);
                check.setStatusApproveSap("APPROVE");
                pqcStoreCheckRepository.save(check);
            }
        } catch (Exception e) {
        }
        return response;
    }

}
