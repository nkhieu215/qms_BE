package com.fn.qms.dto;

import java.util.List;

import com.fn.qms.models.PqcErrorList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TinCheckDTO {
	private Long id;
	private String batchId;
	private String checkPerson;
	private String checkTime;
	private String classify;
	private String conclude;
	private Long dttdCheckId;
	private String errTotal;

	private String expiryDate;
	private String gridCode;
	private String knifeCode;
	private String machineCode;
	private String line;
	private String note;
	private String quatity;
	private String workOrderId;
	private String operators;
	List<TinErrorDTO> lstError;
}
