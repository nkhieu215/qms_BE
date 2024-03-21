package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Machine {
    public String id;
    public String lineId;
    public String machineName;
    public String status;
    public String lane;
    public String workCenterId;
    public ArrayList<Feeder> feeders;
    public  ArrayList<MachineDetail>  machineDetails;
    public Object dnlnvlDetailOfMaterial;
    public Object slotMachine;
    public ArrayList<PartNumber> partNumber;
}
