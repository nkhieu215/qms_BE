package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Feeder {
    public String id;
    public String feederCode;
    public String name;
    public String numberSlot;
    public String qrCode;
    public String serial;
    public String status;
    public ArrayList<QrFeeder> qrFeeders;
    public int qrFeederId;
    public String qrFeederCode;
}
