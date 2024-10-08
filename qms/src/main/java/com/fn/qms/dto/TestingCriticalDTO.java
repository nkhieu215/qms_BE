package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestingCriticalDTO {
    private String testingCriticalGroup;
    private String username;
    private String status;
    private Integer itemPerPage;
    private Integer offSet;
    private Integer id;
    private String createdAt;
    private String updateAt;
    private String note;
    private String type;
    private String testingName;
}
