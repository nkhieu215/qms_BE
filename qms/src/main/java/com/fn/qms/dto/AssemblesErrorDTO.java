package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssemblesErrorDTO {

	private int id;
	private Long dttdCheckId;
	private String dttdType;
	private String errGroup;
	private String errName;
	private int quantity;
	private String ratio;
	private String serial;
}
