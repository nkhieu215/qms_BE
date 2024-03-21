package com.fn.qms.service.base;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.ErrorMachineResponse;
import com.fn.qms.rest.service.FixErrPQCService;
import com.fn.qms.rest.service.ScadaMachineService;
import com.fn.qms.security.services.UserDetailsImpl;
import com.fn.qms.utils.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ScadaServiceBase extends ServiceBase {
    ProcessContext ctx = null;

    public ProcessContext getContext() {
        return ctx;
    }

    @Autowired
    ScadaMachineService scadaMachineService;

    /**
     * lay thong tin setting cua user
     *
     * @param request
     * @param user
     * @return
     */
    public ErrorMachineResponse getMachineByWo(Request request, UserDetailsImpl user, ApplicationContext context) {
        ctx=  loadContext(request, user);
        ctx.setRequest(request);
        ctx.setUser(user);
        ctx.setContext(context);
        try {
            scadaMachineService.execute(ctx);
            logService.execute(ctx);
        } catch (Exception ex) {
            AppLog.error(ex);
            ctx.setResult(Validator.Result.UNKNOWN);
        }
        Validator.Result result = ctx.getResult();
        ErrorMachineResponse resp = new ErrorMachineResponse();
        if (result.isOk()) {
            Response response = ctx.getResponse();
            resp = (ErrorMachineResponse) response.getObj();
        }
        resp.setResult(result);
        return resp;
    }



    @Override
    public ProcessContext loadContext(Request request, UserDetailsImpl userDetails) {
        return super.loadContext(request, userDetails);
    }
}
