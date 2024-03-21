package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrawNvlDTO {
	private Long id;
	private String note;
	private String conclude;
	private String checkPerson;
	private Long workOrderId;
}
