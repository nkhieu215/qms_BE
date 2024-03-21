package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeederGroup {
    public List<Feeder> feeders;
    public List<Feeder> feedersAll;
    public List<FeedersPrograming> feedersPrograming;
}
