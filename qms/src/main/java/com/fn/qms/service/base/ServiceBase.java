package com.fn.qms.service.base;

import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.rest.service.TransactionLogService;
import com.fn.qms.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ServiceBase {
    @Autowired
    TransactionLogService logService;

    public ProcessContext loadContext(Request request, UserDetailsImpl userDetails) {
        Response response = new Response();
        ProcessContext ctx = new ProcessContext();
        ctx.setRequest(request);
        ctx.setUser(userDetails);
        ctx.setResponse(response);
        return ctx;
    }
}
