package com.fn.qms.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrawTestNvlDTO {
	
	private Long id;

	private String allowResult;

	private String checkDate;
	private String externalInspection;
	private String itemCode;

	private String itemName;

	private String lot;

	private String manufactureDate;

	private String maxCosfi;

	private String maxElectric;

	private String maxPower;

	private String minCosfi;

	private String minPower;
	private String minElectric;


	private String note;

	private String partNumber;

	private String poCode;

	private String qty;

	private String rankAp;

	private String rankMau;

	private String rankQuang;

	private String realResult;

	private String regulationCheck;

	private String sampleQuantity;

	private String technicalPara;

	private String vendor;

	private Long workOrderId;	
	private Long pqcDrawNvlId;
	private String paramMax;

	private String paramMin;

	private String unit;
	private String returnDay;
}
