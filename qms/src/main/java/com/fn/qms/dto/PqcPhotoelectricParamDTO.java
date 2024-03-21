package com.fn.qms.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_photoelectric_param database table.
 * 
 */
@Getter
@Setter

public class PqcPhotoelectricParamDTO  {
	private int id;
	private String avg;
	private String avgResult;
	private String checkResult;
	private String content;
	private String kl;
	private String ku;
	private String max;
	private String min;
	private String kmin;
	private String cpk;
	private String cpkLow;
	private String cpkUp;
	private Long parameterId;
//	private Long pqcPhotoelectricId;
	private String auditQAvg;
	private String quantity;
	private String s;
	private String conditions;
	private String parameterName;
	private String unit;
	private String maxAudit;
	private String minAudit;
}