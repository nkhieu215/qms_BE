package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ErrorGRDTO {

    private String label;
    private String name;
    private List<ErrorDTO> lstErr;

    public ErrorGRDTO(String label, String name, List<ErrorDTO> lstErr) {
        this.label = label;
        this.name = name;
        this.lstErr = lstErr;
    }

    public ErrorGRDTO() {
    }
}
