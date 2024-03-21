package com.fn.qms.dto;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fn.qms.models.PqcQuality;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the profile database table.
 * 
 */
@Getter
@Setter
public class PqcQualityCheckDTO implements Serializable {
	private Long quantity;
	private String note;
	private String conclude;
	private Long qualityId;
	private Long templateId;
	private Long invalidNumber;
	private Long workOrderId;
	private Date createdAt;
	private Date updatedAt;
	private String auditContent;
	private String regulationLevel;
	private String technicalRequirement;

	Long id;
}