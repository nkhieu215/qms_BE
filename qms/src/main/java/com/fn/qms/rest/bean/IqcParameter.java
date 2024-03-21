package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IqcParameter {
	private Long id;
	private Long templateId;
	private String name;
	private String condition;
	private Double min;
	private Double max;
	private String unit;
}
