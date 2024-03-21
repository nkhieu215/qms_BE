package com.fn.qms.rest;

import java.util.List;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.dto.SettingMachineDTO;
import com.fn.qms.models.PqcErrorList;
import com.fn.qms.models.PqcWorkOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineResponse extends BaseResponse{
    List<SettingMachineDTO> lstMachine;
}
