package com.fn.qms.service.base;

import com.fn.qms.rest.*;
import com.fn.qms.rest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceBase extends ServiceBase {

    @Autowired
    ErrorCommonService errorCommonService;

    @Autowired
    GetStepProcessScadaService getStepProcessScadaService;

    @Autowired
            GetMachineScadaService getMachineScadaService;

    @Autowired
    GetLineService getLineService;

    ProcessContext ctx ;

    public ProcessContext getContext() {
        return ctx;
    }

    @Override
    public ProcessContext loadContext(Request request, UserDetailsImpl userDetails) {

        ctx =  super.loadContext(request, userDetails);
        ctx.setRequest(request);
        ctx.setUser(userDetails);
        return ctx;
    }

    /**
     * lay thong tin loi
     *
     * @param request
     * @param user
     * @return
     */
    public ErrorListResponse crudError(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext  ctx  = loadContext(request, user);
        ctx.setContext(context);
        ErrorCrudService service = new ErrorCrudService();
        TransactionLogService logService = new TransactionLogService();
        try {
            service.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }
        Validator.Result result = ctx.getResult();
        ErrorListResponse resp = new ErrorListResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (ErrorListResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    } /**
     * lay thong tin loi
     *
     * @param request
     * @param user
     * @return
     */
    public ErrorListResponse errorList(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext ctx  = loadContext(request, user);
        ctx.setContext(context);
        try {
            errorCommonService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }

        Validator.Result result = ctx.getResult();
        ErrorListResponse resp = new ErrorListResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (ErrorListResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }

    public ErrorListResponse searchErrorScada(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext  ctx  = loadContext(request, user);
        ctx.setContext(context);
        try {
            errorCommonService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }

        Validator.Result result = ctx.getResult();
        ErrorListResponse resp = new ErrorListResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (ErrorListResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }

    public StepProcessResponse getStepProcess(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext ctx = loadContext(request, user);
        ctx.setContext(context);
        try {
            getStepProcessScadaService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }

        Validator.Result result = ctx.getResult();
        StepProcessResponse resp = new StepProcessResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (StepProcessResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }


    public MachineResponse getMachineList(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext ctx = loadContext(request, user);
        ctx.setContext(context);
        try {
            getMachineScadaService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }

        Validator.Result result = ctx.getResult();
        MachineResponse resp = new MachineResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (MachineResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }

    public LineResponse getLineList(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext ctx = loadContext(request, user);
        ctx.setContext(context);
        try {
            getLineService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }

        Validator.Result result = ctx.getResult();
        LineResponse resp = new LineResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (LineResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }
}
