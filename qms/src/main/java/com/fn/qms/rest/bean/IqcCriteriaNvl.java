package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IqcCriteriaNvl {
	private Long id;
	private String criteriaName;
	private String level;
	private String regulationLevel;
	private String min;
	private String max;
	private String unit;
	private String note;
	private int type;
	
	private Long templateId;
}
