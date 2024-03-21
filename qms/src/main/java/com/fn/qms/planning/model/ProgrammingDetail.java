package com.fn.qms.planning.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgrammingDetail {
    public String id;    
    public Feeder qrFeeder;
    public Part part;
}
