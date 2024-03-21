package com.fn.scada.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StageByWoId {
    @JsonProperty("list_stage")
    public ArrayList<ListStage> listStage;

    @JsonProperty("his_list_stage")
    public ArrayList<ListStage> hisListStage;

    @JsonProperty("Status_Wo")
    public List<ScadaKeyValue> status;
}
