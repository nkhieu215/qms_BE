package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AssemblesSuccessCheckDTO {
    private long id;
    private String lotNumber;
    private String line;
    private String processName;
    private String checkPerson;
    private String quatity;
    private String quatityPass;
    private String quatityFail;
    private String ratio;
    private String conclude;
    private String note;
    private String checkTime;
    private Long workOrderId;
    private Date createdAt;
    private Date updatedAt;
    private String operators;
    List<AssemblesErrorDTO> lstError;
}
