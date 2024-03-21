package com.fn.sap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class ItemInfor {
    @JsonProperty("ItemCode")
    public String itemCode;
    @JsonProperty("PartNumberInfor")
    public ArrayList<PartNumberInfor> partNumberInfor;
}
