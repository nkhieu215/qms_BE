package com.fn.sap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class PartNumberInfor{
    @JsonProperty("PartNumber")
    public String partNumber;
    @JsonProperty("LotNumber")
    public Object lotNumber;
    @JsonProperty("Color")
    public String color;
    @JsonProperty("MaterialInfor")
    public ArrayList<MaterialInfor> materialInfor;
}
