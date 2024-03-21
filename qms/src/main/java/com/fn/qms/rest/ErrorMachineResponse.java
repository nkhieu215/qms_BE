package com.fn.qms.rest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fn.qms.dto.MachineResDTO;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcWorkOrder;

import com.fn.scada.dto.ListStage;
import com.fn.scada.dto.StageMachine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMachineResponse extends BaseResponse{
    Map<String, MachineResDTO> lstMachine;
    List<ListStage> lstStages;

    List<MachineResDTO> lstError;
}
