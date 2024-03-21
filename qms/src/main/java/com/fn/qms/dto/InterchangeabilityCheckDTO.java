package com.fn.qms.dto;

import com.fn.qms.models.PqcErrorList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InterchangeabilityCheckDTO {
    private Long id;
    private String lot;
    private String line;    //
    private String checkPerson;
    private String checkTime;
    private int quatity;
    private String externalInspection;
    private String powMin;
    private String powMax;
    private String fiMin;
    private String fiMax;
    private String elecMin;
    private String elecMax;
    private String conclude;
    private String note;
    private String total;
    private String operators;
    private Long workOrderId;
    private Date createdAt;
    private Date updatedAt;

    List<ErrorListDTO> errorLists;
}
