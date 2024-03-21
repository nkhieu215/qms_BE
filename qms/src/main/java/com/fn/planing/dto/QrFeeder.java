package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class QrFeeder {
    public String id;
    public String qrFeederCode;
    public Object name;
    public Object note;
    public Date createdDate;
}
