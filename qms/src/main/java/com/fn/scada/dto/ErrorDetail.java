package com.fn.scada.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {
    @JsonProperty("err_key")
    public String errKey;
    public String value;

    public String name;
}
