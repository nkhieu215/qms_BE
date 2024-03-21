package com.fn.qms.service.base;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.service.FixErrPQCService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FixErrorServiceBase extends ServiceBase {
    ProcessContext ctx = null;

    public ProcessContext getContext() {
        return ctx;
    }

    @Autowired
    FixErrPQCService fixErrPQCService;

    /**
     * lay thong tin setting cua user
     *
     * @param request
     * @param user
     * @return
     */
    public BaseResponse createUpdate(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext ctx=  loadContext(request, user);
        ctx.setRequest(request);
        ctx.setUser(user);
        ctx.setContext(context);
        try {
            fixErrPQCService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }
        Validator.Result result = ctx.getResult();
        BaseResponse resp = new BaseResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (BaseResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }/**
     * lay thong tin setting cua user
     *
     * @param request
     * @param user
     * @return
     */
    public BaseResponse remove(Request request, UserDetailsImpl user, ApplicationContext context) {
        ProcessContext  ctx=  loadContext(request, user);
        ctx.setRequest(request);
        ctx.setUser(user);
        ctx.setContext(context);
        try {
            fixErrPQCService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }
        Validator.Result result = ctx.getResult();
        BaseResponse resp = new BaseResponse();
        if (result.isOk()) {
        }
        resp.setResult(result);
        return resp;
    }


    @Override
    public ProcessContext loadContext(Request request, UserDetailsImpl userDetails) {
        return super.loadContext(request, userDetails);
    }
}
