package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class Feeder {
    public String id;
    public Date entryDate;
    public String feederCode;
    public ArrayList<QrFeeder> qrFeeders;
    public Object name;
    public String numberSlot;
    public String qrCode;
    public String serial;
    public String status;
}
