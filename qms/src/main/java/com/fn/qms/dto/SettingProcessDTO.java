package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SettingProcessDTO {
    private Long id;
    private String name;
    private String code;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    private Integer page;
    private Integer size;
}
