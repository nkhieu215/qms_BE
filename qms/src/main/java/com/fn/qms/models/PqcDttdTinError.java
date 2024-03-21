package com.fn.qms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the pqc_error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_dttd_tin_error")
@NamedQuery(name="PqcDttdTinError.findAll", query="SELECT p FROM PqcDttdTinError p")
public class PqcDttdTinError implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="dttd_check_id")
	private Long dttdCheckId;

	@Column(name="dttd_type")
	private String dttdType;

	@Column(name="err_group")
	private String errGroup;

	@Column(name="err_name")
	private String errName;

	private int quantity;

	private String ratio;

	private String serial;
	public PqcDttdTinError() {
	}

	@ManyToOne(optional=true)
	@JoinColumn(name = "dttd_check_id", insertable=false, updatable=false)
	@JsonIgnore
	private PqcDttdTinCheck tinCheck;

	
}