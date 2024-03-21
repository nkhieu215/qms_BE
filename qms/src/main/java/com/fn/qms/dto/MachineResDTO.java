package com.fn.qms.dto;

import com.fn.qms.models.Error;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MachineResDTO {
    Map<String, Object> errorLst;
    Integer numberInput;
    Integer numberOutput;

    // phuc vu xuat excel
    String name;
    List<KeyValueDTO> errorExcel;
}
