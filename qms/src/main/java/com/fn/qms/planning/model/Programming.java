package com.fn.qms.planning.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Programming {
	public String id;
	public List<ProgrammingDetail> programmingDetails;
}
