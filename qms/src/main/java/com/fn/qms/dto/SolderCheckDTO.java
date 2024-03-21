package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class SolderCheckDTO {

	private Long dttdSolderCheckId;
	private String batchId;
	private String checkPerson;
	private String checkTime;
	private String conclude;
	private int errTotal;
	private String line;
	private String machineName;
	private String note;
	private int quatity;
	private Long workOrderId;
	private String operators;
	List<SolderErrorDTO> lstError;
}
