package com.fn.qms.planning.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Part {

    public int id;
    public String name;
    public String description;
    public String partNumberCode;
    public String vendor;
}
