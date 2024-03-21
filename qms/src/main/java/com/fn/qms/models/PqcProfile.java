package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The persistent class for the profile database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "pqc_profile")
@NamedQuery(name = "PqcProfile.findAll", query = "SELECT p FROM PqcProfile p")
public class PqcProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "work_order_id")
	private Long workOrderId;

	@Column(name = "profile_id")
	private int profileId;

	@Column(name = "profile_name")
	private String profileName;

	@Column(name = "profile_code")
	private String profileCode;

}