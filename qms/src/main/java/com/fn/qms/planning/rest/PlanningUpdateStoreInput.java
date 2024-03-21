package com.fn.qms.planning.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanningUpdateStoreInput {
	private String wo;
	private String quantity;
	private String mode;
	String updateId;
}
