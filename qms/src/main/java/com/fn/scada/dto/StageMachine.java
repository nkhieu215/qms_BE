package com.fn.scada.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
public class StageMachine {
    @JsonProperty("stage_name")
    public String machineName;
    @JsonProperty("Number_Of_Input")
    public int numberOfInput;
    @JsonProperty("Number_Of_Output")
    public int numberOfOutput;
    @JsonProperty("Number_Of_Error")
    public int numberOfError;
    public ScadaAssetsId assetId;
    @JsonProperty("Error_Detail")
    public ArrayList<ErrorDetail> errorDetail;

    @JsonProperty("Error_Detail_HMI")
    public Object errorDetailHmi;
}
