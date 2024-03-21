package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApproveHisDTO {
    private Integer id;
    private String type;
    private String userId;
    private String approveStatus;
    private String note;
    private Integer checkId;
    private Date createdAt;
    private Date updatedAt;

}
