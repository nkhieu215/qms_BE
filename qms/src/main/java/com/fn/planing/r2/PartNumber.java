package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PartNumber {
    public String id;
    public String partNumberCode;
    public String name;
    public ArrayList<Object> subPart;
    public ArrayList<Material> materials;
    public List<Object> qrFeederDtos;
}
