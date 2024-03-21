package com.fn.qms.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the pqc_error_list database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="pqc_error_list")
@NamedQuery(name="PqcErrorList.findAll", query="SELECT p FROM PqcErrorList p")
public class PqcErrorList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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

	public PqcErrorList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}