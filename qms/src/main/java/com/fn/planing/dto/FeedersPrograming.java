package com.fn.planing.dto;

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
    public Object partNumberName;
    public Date entryDate;
    public String serial;
    public String status;
    public ArrayList<DnlnvlDetailOfMaterial> dnlnvlDetailOfMaterial;
    public String slotMachine;
}
