package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    String name;
    String id;
    String label;
    public ErrorDTO(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public ErrorDTO() {

    }
}
