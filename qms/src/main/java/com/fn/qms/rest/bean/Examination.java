package com.fn.qms.rest.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Examination {

	private Long id;
	private String name;
	private String code;
	private Integer type;
	private String description;	
	private String status;
	private String createdAt;
	private String updatedAt;
}
