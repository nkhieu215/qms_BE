package com.fn.qms.command;

import com.fn.qms.dto.iqc.nvl.IqcExaminationDTO;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.bean.ProcessContext;
import com.fn.qms.bean.Request;
import com.fn.qms.bean.Response;
import com.fn.qms.constant.Constant;
import com.fn.qms.models.IqcExaminationType;
import com.fn.qms.repository.DAO.ExaminationDAO;
import com.fn.qms.rest.iqc.ExaminationRequest;
import com.fn.qms.rest.iqc.ExaminationResponse;
import com.fn.qms.utils.AppLog;

import java.lang.reflect.Type;
import java.util.List;

public class Examination implements Command {

    @Override
    public boolean execute(Context cntxt) throws Exception {
        AppLog.info(((ProcessContext) cntxt).getRequest().getRequestId() + " " + this.getClass().getSimpleName());
        ProcessContext context = (ProcessContext) cntxt;
        Response response = context.getResponse();
        Validator.Result result = Validator.Result.OK;
        ApplicationContext ctx = context.getContext();

        Request request = context.getRequest();
        ExaminationRequest param = request.getExaminationRequest();
        String typeRequest = param.getTypeRequest();
        ExaminationDAO examinationService = ctx.getBean(ExaminationDAO.class);
        ExaminationResponse res = new ExaminationResponse();
        ModelMapper modelMapper = new ModelMapper();
        switch (typeRequest) {
            case Constant.ACTION_BROWS:
                Page<IqcExaminationType> pageContent = examinationService.getLstExaminationByPage(param.getPage(),
                        param.getSize(), param.getName(), param.getType(), param.getCode());


                List<IqcExaminationType> lst = pageContent.getContent();
                Type listType = new TypeToken<List<IqcExaminationDTO>>(){}.getType();
                List<IqcExaminationDTO> lstDto = modelMapper.map(lst,listType);

                res.setLstExamination(lstDto);
                res.setTotal(pageContent.getTotalPages());
                break;
            case Constant.ACTION_SHOW:
                IqcExaminationType detail = examinationService.getExamination(param.getId());
                IqcExaminationDTO dto = modelMapper.map(detail,IqcExaminationDTO.class);
                res.setExaminationType(dto);
                break;
            case Constant.ACTION_ADD:
            case Constant.ACTION_EDIT:
                examinationService.saveIqcExamination(param.getExamination(), param.getLstCriteriaLkdt(),
                        param.getLsCriteriaNvl(), param.getLstParameter(), param.getLstCriteriaQualities());
                break;
            default:
                break;
        }

        response.setObj(res);
        context.setResult(result);
        return !result.isOk();
    }

}
