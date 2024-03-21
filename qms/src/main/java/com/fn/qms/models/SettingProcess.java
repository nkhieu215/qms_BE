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
@Table(name = "setting_process")
@NamedQuery(name = "SettingProcess.findAll", query = "SELECT p FROM SettingProcess p")
public class SettingProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;


	public SettingProcess() {
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