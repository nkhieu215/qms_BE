package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MachineDetail {
    public String side;
    public ArrayList<FeedersPrograming> feedersPrograming;
}
