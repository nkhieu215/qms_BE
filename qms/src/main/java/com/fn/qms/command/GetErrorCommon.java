package com.fn.qms.command;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.ErrorDTO;
import com.fn.qms.dto.ErrorGRDTO;
import com.fn.qms.models.Error;
import com.fn.qms.models.ErrorGroup;
import com.fn.qms.models.ErrorLstGr;
import com.fn.qms.repository.DAO.ErrorListDAO;
import com.fn.qms.repository.ErrorGroupRepository;
import com.fn.qms.repository.ErrorLstGrRepository;
import com.fn.qms.repository.ErrorRepository;
import com.fn.qms.rest.BaseRequest;
import com.fn.qms.rest.ErrorListRequest;
import com.fn.qms.rest.ErrorListResponse;
import com.fn.qms.utils.AppLog;
import com.fn.rd.models.ErrorList;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GetErrorCommon implements Command {

    @Autowired
    ErrorGroupRepository errorGroupRepository;

    @Autowired
    ErrorRepository errorRepository;

    @Override
    public boolean execute(Context cntxt) throws Exception {
        AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
        ProcessContext context = (ProcessContext) cntxt;
        Response response = context.getResponse();
        Validator.Result result = Validator.Result.OK;
        ApplicationContext ctx = context.getContext();
        Request request = context.getRequest();
        BaseRequest param = request.getBaseRequest();

        ErrorListResponse res = new ErrorListResponse();
        if("SEARCH".equalsIgnoreCase(param.getTypeRequest())){
            List<Error> lstError = errorRepository.searchListByName(param.getSearch());
            ErrorDTO errorDTO;
            List<ErrorDTO> lstErrDTO = new ArrayList<>();
            for (Error error: lstError) {
                errorDTO = new ErrorDTO(error.getLabel(),error.getName());
                lstErrDTO.add(errorDTO);
            }
            res.setLstErrorScada(lstErrDTO);
        }else{
            List<ErrorGroup> lstError = errorGroupRepository.findAll();
            List<ErrorGRDTO> lstErrGrDTO = new ArrayList<>();
            ErrorGRDTO errorGRDTO;
            for (ErrorGroup errGr: lstError) {
                List<ErrorDTO> lstErrDTO = new ArrayList<>();
                ErrorDTO errorDTO;
                for (Error error: errGr.getErrLst()) {
                    errorDTO = new ErrorDTO(error.getLabel(),error.getName());
                    lstErrDTO.add(errorDTO);
                }
                errorGRDTO = new ErrorGRDTO(errGr.getLabel(), errGr.getName(),lstErrDTO);
                lstErrGrDTO.add(errorGRDTO);
            }

            res.setLstGr(lstErrGrDTO);
        }



        response.setObj(res);

        context.setResult(result);
        return !result.isOk();
    }

}
