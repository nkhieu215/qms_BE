package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class FeedersPrograming {
    public String id;
    public String qrFeederId;
    public String qrFeederCode;
    public String partNumberName;
    public Date entryDate;
    public String serial;
    public Object status;
    public ArrayList<DnlnvlDetailOfMaterial> dnlnvlDetailOfMaterial;
    public String slotMachine;
}
