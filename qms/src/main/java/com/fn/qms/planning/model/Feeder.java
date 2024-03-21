package com.fn.qms.planning.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feeder {
    public int id;
    public String feederCode;
    public int maintainTime;
    public String name;
    public String ncc;
    public String qrCode;
    public String serial;
}
