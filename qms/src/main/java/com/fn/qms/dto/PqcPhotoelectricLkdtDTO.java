package com.fn.qms.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the pqc_photoelectric_lkdt database table.
 * 
 */
@Getter
@Setter
public class PqcPhotoelectricLkdtDTO {
	private static final long serialVersionUID = 1L;
	private int id;
	private String checkContent;
	private String checkResult;
	private Long electCompId;
	private String inaccuracy;
//	private Long pqcPhotoelectricId;
	private String auditQuantity;
	private String auditContent;
	private String regulationLevel;
	private String technicalRequirement;
	private String quantity;

}