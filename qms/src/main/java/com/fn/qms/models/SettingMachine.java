package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the pqc_store_err database table.
 * 
 */
@Setter
@Getter
@Entity
@Table(name="setting_machine")
@NamedQuery(name="SettingMachine.findAll", query="SELECT p FROM SettingMachine p")
public class SettingMachine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_scada")
	private String idScada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String name;

	@Column(name="description")
	private String description;

	@Column(name="source")
	private String source;

	@Column(name="code")
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@PrePersist
	public void create() {
		updatedAt  = createdAt  = new Date();
	}

	public SettingMachine() {
	}

}