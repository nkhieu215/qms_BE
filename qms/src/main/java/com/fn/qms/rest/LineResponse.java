package com.fn.qms.rest;

import com.fn.qms.dto.SettingLineDTO;
import com.fn.sap.models.Coitt;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LineResponse extends BaseResponse{
    List<SettingLineDTO> lstLine;
}
