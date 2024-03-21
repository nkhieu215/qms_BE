package com.fn.rd.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the action_log database table.
 * 
 */
@Entity
@Table(name="action_log")
@NamedQuery(name="ActionLog.findAll", query="SELECT a FROM ActionLog a")
public class ActionLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="action_log_id")
	private int actionLogId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_time")
	private Date endTime;

	@Column(name="error_code")
	private String errorCode;

	@Column(name="error_description")
	private String errorDescription;

	@Column(name="module_code")
	private String moduleCode;

	@Column(name="process_name")
	private String processName;

	@Column(name="request_content")
	private String requestContent;

	@Column(name="request_ip_address")
	private String requestIpAddress;

	@Column(name="response_content")
	private String responseContent;

	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Date startTime;

	@Column(name="user_name")
	private String userName;

	public ActionLog() {
	}

	public int getActionLogId() {
		return this.actionLogId;
	}

	public void setActionLogId(int actionLogId) {
		this.actionLogId = actionLogId;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getModuleCode() {
		return this.moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getRequestContent() {
		return this.requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getRequestIpAddress() {
		return this.requestIpAddress;
	}

	public void setRequestIpAddress(String requestIpAddress) {
		this.requestIpAddress = requestIpAddress;
	}

	public String getResponseContent() {
		return this.responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}