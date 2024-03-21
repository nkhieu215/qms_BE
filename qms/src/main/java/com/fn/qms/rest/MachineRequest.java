package com.fn.qms.rest;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.dto.SettingMachineDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineRequest extends BaseRequest{

    String name;
    String code;
    String idScada;
    SettingMachineDTO dataRequest;

    String type;
}
