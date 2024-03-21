package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingLineDTO {
    private Long id;
    private String idScada;
    private String name;
    private String description;
    private String code;
    private String source;

}
