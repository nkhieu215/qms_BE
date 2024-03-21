package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedersPrograming
{
    public List<Feeder> qrFeeders;
    public String qrCode;
    public String serial;
}
