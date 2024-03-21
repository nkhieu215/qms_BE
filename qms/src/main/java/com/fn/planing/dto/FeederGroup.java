package com.fn.planing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class FeederGroup {
    public String id;
    public Date createdAt;
    public String feederGroupCode;
    public String name;
    public String type;
    public Date updatedAt;
    public ArrayList<Feeder> feeders;
}
