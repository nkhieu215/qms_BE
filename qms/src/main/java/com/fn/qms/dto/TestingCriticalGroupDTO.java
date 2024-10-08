package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class TestingCriticalGroupDTO {
    private String testingCriticalGroup;
    private String username;
    private String status;
    private Integer itemPerPage;
    private Integer offSet;
    private Integer id;
    private String createdAt;
    private String updateAt;
    private String note;
}
