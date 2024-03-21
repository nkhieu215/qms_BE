package com.fn.qms.rest;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.qms.models.PqcWorkOrderPlanning;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LineRequest extends BaseRequest{

    String name;
    String code;
    String idScada;
    SettingLineDTO dataRequest;

    String type;
}
