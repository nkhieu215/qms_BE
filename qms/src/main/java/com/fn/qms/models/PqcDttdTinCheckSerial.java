package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pqc_dttd_tin_check database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_dttd_tin_check_serial")
@NamedQuery(name = "PqcDttdTinCheckSerial.findAll", query = "SELECT p FROM PqcDttdTinCheckSerial p")
public class PqcDttdTinCheckSerial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "check_person")
	private String checkPerson;

	@Column(name = "check_time")
	private String checkTime;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_gia")
	private String endGia;

	@Column(name = "serial")
	private String serial;

	@Column(name = "end_khuay")
	private String endKhuay;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_gia")
	private String startGia;

	@Column(name="start_khuay")
	private String startKhuay;
	@Column(name="operators")
	private String operators;
	@Column(name="note")
	private String note;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name = "work_order_id")
	private Long workOrderId;

	public PqcDttdTinCheckSerial() {
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