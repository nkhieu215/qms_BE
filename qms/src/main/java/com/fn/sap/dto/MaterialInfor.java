package com.fn.sap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialInfor {

    @JsonProperty("MaterialId")
    public String materialId;
    @JsonProperty("MaterialQuantity")
    public String materialQuantity;

}
