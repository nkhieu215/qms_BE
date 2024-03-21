package com.fn.planing.r2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FeederGroup {
    public String id;
    public String feederGroupCode;
    public String name;
    public String type;
    public ArrayList<Feeder> feeders;
}
