package com.fn.qms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_his")
@NamedQuery(name = "TransactionHistory.findAll", query = "SELECT i FROM TransactionHistory i")
public class TransactionHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "request_time")
	private Date requestTime;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "request_content")
	private String requestContent;

	@Column(name = "path")
	private String path;

	@Column(name = "ip")
	private String ip;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "response_code")
	private String responseCode;

	@Column(name = "response")
	private String response;

	@Column(name = "server_ip")
	private String serverIp;

	@Column(name = "request_id")
	private String requestId;

	@PrePersist
	void createdAt() {
		this.createdAt = this.requestTime = new Date();
	}
}
