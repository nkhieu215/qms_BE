package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class StepProcessDTO {
	private String name;
	private String type;
	private String label;
	private String description;
	private String idStage;
}
