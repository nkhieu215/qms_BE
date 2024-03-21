package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class OrderStepStatusDTO {
    private Long id;
    private Long pqcWorkOrder;

    private String userId;
    private String status;
    private String step;
    private Date createdAt;
    private Date updatedAt;
}
