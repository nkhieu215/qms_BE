package com.fn.qms.services;

import com.fn.qms.base.validator.Validator;
import com.fn.qms.constant.Constant;
import com.fn.qms.dto.PqcQualityCheckDTO;
import com.fn.qms.dto.PqcQualityDTO;
import com.fn.qms.dto.StepStatusDTO;
import com.fn.qms.models.*;
import com.fn.qms.repository.*;
import com.fn.qms.rest.BaseResponse;
import com.fn.qms.rest.PqcApproveRequest;
import com.fn.qms.rest.QcCheckRequest;
import com.fn.qms.utils.Utils;
import com.google.common.collect.ImmutableList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PqcService {

    @Autowired
    PqcWoHistoryRepository pqcQualityRepository;

    @Autowired
    PqcWorkOrderStepStatusRepository pqcWorkOrderStepStatusRepository;

    @Autowired
    PqcWorkOrderRepository pqcWorkOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BaseResponse approve(PqcApproveRequest param) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Validator.Result result = Validator.Result.OK;
        BaseResponse response = new BaseResponse();
        PqcWorkOrderApproveHist check = modelMapper.map(param.getData(), PqcWorkOrderApproveHist.class);
        check = pqcQualityRepository.save(check);

        PqcWorkOrder pqcWorkOrder = pqcWorkOrderRepository.getById(param.getData().getWorkOrderId());
        if (Constant.ACTION_APPROVE.equalsIgnoreCase(param.getData().getType()) || Constant.ACTION_CONCESSIONS.equalsIgnoreCase(param.getData().getType())) {
            List<StepStatusDTO> lstStep = param.getData().getLstStep();
            if (Constant.ACTION_CONCESSIONS.equalsIgnoreCase(param.getData().getType())) {
                pqcWorkOrder.setStatus(Constant.IQC_STATUS_CONCESSIONS);
            } else {
                pqcWorkOrder.setStatus(Constant.IQC_STATUS_APPROVE);
            }

            for (StepStatusDTO dto : lstStep) {
                List<String> step = ImmutableList.of(dto.getStep());
                if (dto.isChecked()) {
                    pqcWorkOrderStepStatusRepository.updateStep(dto.getPqcWorkOrder(), Constant.SUCCESS, step);
                }
            }
        } else if (Constant.REJECT.equalsIgnoreCase(param.getData().getType()) || Constant.PQC_NOT_APPROVE.equalsIgnoreCase(param.getData().getType())) {
//            pqcWorkOrder.setStatus(Constant.REJECT);
            // code thêm trạng thái mới
            List<StepStatusDTO> lstStep = param.getData().getLstStep();
            if (Constant.REJECT.equalsIgnoreCase(param.getData().getType())) {
                pqcWorkOrder.setStatus(Constant.REJECT);
                for (StepStatusDTO dto : lstStep) {
                    List<String> step = ImmutableList.of(dto.getStep());
                    String status = dto.isChecked() ? Constant.SUCCESS : Constant.REJECT;
                    pqcWorkOrderStepStatusRepository.updateStep(dto.getPqcWorkOrder(), status, step);
                }
            } else {
                pqcWorkOrder.setStatus(Constant.PQC_NOT_APPROVE);
            }
        }
        pqcWorkOrderRepository.save(pqcWorkOrder);


        if(Constant.IQC_STATUS_CONCESSIONS.equalsIgnoreCase(pqcWorkOrder.getStatus()) || Constant.REJECT.equalsIgnoreCase(pqcWorkOrder.getStatus())){
            Utils.buildPqcWarning(Constant.APPROVE_STORE,"",pqcWorkOrder, pqcWorkOrder.getStatus(),param.getData().getNote());
        }




        response.setId(check.getId());
        return response;
    }

    public void updateStatus (List<PqcWorkOrderStepStatus> requests ){
        for (PqcWorkOrderStepStatus request :requests){
            PqcWorkOrderStepStatus response = this.pqcWorkOrderStepStatusRepository.findById(request.getId()).orElse(null);
            response.setStatus("SUCCESS");
            this.pqcWorkOrderStepStatusRepository.save(response);
        }
    }
}
