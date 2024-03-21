package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PqcFixErrDTO {
    private int id;
    private String errGr;
    private String errName;
    private String note;
    private String quantity;
    private String ratio;
    private String serial;
    private String userId;
    private Long workOrderId;
    private String quantityErr;
    private String lotNumber;
    private String stage;
    private String materials;
}
