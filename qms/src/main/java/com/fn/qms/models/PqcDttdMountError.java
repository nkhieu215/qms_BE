package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_dttd_mount_error")
@NamedQuery(name="PqcDttdMountError.findAll", query="SELECT p FROM PqcDttdMountError p")
public class PqcDttdMountError implements Serializable {
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

	public PqcDttdMountError() {
	}

	@ManyToOne(optional=true)
	@JoinColumn(name = "dttd_check_id", insertable=false, updatable=false)
	@JsonIgnore
	private PqcDttdMountCompCheck mountCompCheck;

	
}