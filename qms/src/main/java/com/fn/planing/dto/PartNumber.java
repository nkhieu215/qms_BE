package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PartNumber {
    public String id;
    public String partNumberCode;
    public String name;
    public ArrayList<Object> subPart;
}
