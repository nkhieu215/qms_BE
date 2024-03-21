package com.fn.qms.command;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.PqcFixErr;
import com.fn.qms.models.PqcWorkOrder;
import com.fn.qms.repository.PqcFixErrorRepository;
import com.fn.qms.repository.PqcWorkOrderRepository;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PqcFixErrRequest;
import com.fn.qms.utils.AppLog;
import com.fn.qms.utils.Utils;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PqcFixError implements Command {
    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PqcFixErrorRepository pqcFixErrorRepository;

    @Override
    public boolean execute(Context cntxt) throws Exception {
        AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
        ProcessContext context = (ProcessContext) cntxt;
        Response response = context.getResponse();
        Validator.Result result = Validator.Result.OK;
        ApplicationContext ctx = context.getContext();


        Request request = context.getRequest();
        PqcFixErrRequest param = (PqcFixErrRequest) request.getBaseRequest();
        BaseResponse res = new BaseResponse();
        if ("DELETE".equalsIgnoreCase(param.getType())) {
            PqcFixErr fixErr = pqcFixErrorRepository.findById(param.getId()).get();
            if (fixErr != null)
                pqcFixErrorRepository.deleteById(param.getId());
        } else {
            PqcFixErr fixErr = modelMapper.map(param.getData(), PqcFixErr.class);
            fixErr =  pqcFixErrorRepository.save(fixErr);
            res.setId(fixErr.getId());
            response.setObj(res);
        }


        context.setResult(result);
        return !result.isOk();
    }

}
