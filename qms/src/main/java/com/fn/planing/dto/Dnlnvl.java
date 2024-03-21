package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Dnlnvl {
    public String status;
    public String createdAt;
    public String updatedAt;
    public ArrayList<PartNumber> partNumber;
    public ArrayList<FeederGroup> feederGroup;
    public ArrayList<Machine> machine;
}
