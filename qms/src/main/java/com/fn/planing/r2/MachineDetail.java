package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MachineDetail {
    public String side;
    public ArrayList<FeedersPrograming> feedersPrograming;
}
