package com.fn.scada.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ListStage {
    public long ts;
    public ArrayList<StageMachine> value;
}
