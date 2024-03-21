package com.fn.qms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the pqc_dttd_tin_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "noti_config")
@NamedQuery(name = "NotiConfig.findAll", query = "SELECT p FROM NotiConfig p")
public class NotiConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "note")
	private String note;

	@Column(name = "type")
	private String type;
	@Column(name = "warning_type")
	private String warningType;

	@Column(name = "topic")
	private String topic;
	@Column(name = "app_name")
	private String appName;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;


	public NotiConfig() {
	}
	
	@PrePersist
	public void onCreate() {
		createdAt = updatedAt = new Date();
	}
	
	@PreUpdate
	public void update() {
		updatedAt = new Date();
	}
}