package com.fn.qms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MountCheckDTO {

	private Long dttdMountCompId;
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
	List<MountErrorDTO> lstError;
}
