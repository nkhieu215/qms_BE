package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class StepStatusDTO {
    private Long pqcWorkOrder;
    private String userId;
    private String status;
    private String step;
    private Date createdAt;
    private Date updatedAt;
    private SettingDTO setting;
    private String nameStep;
    private boolean checked;

}
