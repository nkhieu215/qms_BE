package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Machine {
    public String id;
    public Object lineId;
    public String machineName;
    public String status;
    public String lane;
    public Object workCenterId;
    public ArrayList<MachineDetail> machineDetails;
}
