package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stage_code database table.
 * 
 */
@Entity
@Table(name="stage_code")
@NamedQuery(name="StageCode.findAll", query="SELECT s FROM StageCode s")
public class StageCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stage_code")
	private String stageCode;

	@Column(name="stage_name")
	private String stageName;

	private int status;

	public StageCode() {
	}

	public String getStageCode() {
		return this.stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}