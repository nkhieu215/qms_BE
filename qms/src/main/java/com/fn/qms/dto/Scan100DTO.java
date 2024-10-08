package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Scan100DTO {
    private Long id;
    private String machine;
    private String side;
    private String feeder;
    private String material;
    private String qr;
    private String date;
    private Boolean status;
    private String user_check;
    private Long workOrderId;
    private String timeConfirmed;
    private String reason;
    private String confirm;
    private Date createdAt;
    private Date updatedAt;
}
